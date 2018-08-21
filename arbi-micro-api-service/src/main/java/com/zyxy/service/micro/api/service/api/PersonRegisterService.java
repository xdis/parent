package com.zyxy.service.micro.api.service.api;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.zyxy.common.constants.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyxy.common.custom.MyMultipartFile;
import com.zyxy.common.domain.LitigantInfo;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.SysUserExample;
import com.zyxy.common.dto.ElementVerifyDTO;
import com.zyxy.common.dto.UserRegisterDTO;
import com.zyxy.common.enums.LitigantUserTypeEnum;
import com.zyxy.common.enums.SysEnum;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.util.ImageUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.dto.ReqPersonRegisterDTO;
import com.zyxy.service.micro.api.dto.ResRegisterDTO;
import com.zyxy.service.micro.api.service.micro.SysUserService;

/**
 * 自然人注册
 * @author tanquan
 */
@Service
public class PersonRegisterService extends BaseService<ReqPersonRegisterDTO, ResRegisterDTO>{
    
    @Autowired
    private SysUserService microSysUserService;
    @Autowired
    private MicroFileService microFileService;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private LitigantInfoMapper litigantInfoMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Override
    protected  BuzzResultVO<ResRegisterDTO> doBuzz(ReqPersonRegisterDTO dto, String currentIp) {
        // 是否已经注册
        SysUserExample suEx = new SysUserExample();
        suEx.createCriteria().andUserNameEqualTo(dto.getUserName());
        List<SysUser> dbUserList = sysUserMapper.selectByExample(suEx);
        SysUser dbUser = dbUserList == null || dbUserList.isEmpty() ? null : dbUserList.get(0);
        if (dbUser == null) {
            // 用户基本信息注册
            UserRegisterDTO userRegDTO = new UserRegisterDTO();
            userRegDTO.setIp(currentIp);
            userRegDTO.setPhone(dto.getUserName());
            userRegDTO.setPassword(dto.getPassword());
            userRegDTO.setType("0"); // 0-自然人，1-公司法人
            userRegDTO.setResourceOrgId(dto.getOrgNo());
            String code = "123456";
            this.setSmsCode(dto.getUserName(), code);
            userRegDTO.setSmsVerifyCode(code);
            ApiResultVO<String> regRet = microSysUserService.register(userRegDTO);
            if (!super.isApiExcuteSuccess(regRet)) {
                return super.error(super.getApiExcuteMessage(regRet));
            }
            dbUserList = sysUserMapper.selectByExample(suEx);
            if (dbUserList == null || dbUserList.isEmpty()) {
                return super.error("注册失败");
            }
            dbUser = dbUserList.get(0);
        } else if (!dto.getOrgNo().equals(dbUser.getResourceOrgId())) {
            return super.error("当前userName已被注册，请确认用户名正确性");
        } 
        ResRegisterDTO resVO = new ResRegisterDTO();
        resVO.setUserId(dbUser.getId());
        if ("0".equals(dto.getRegisterType())) { // 仅注册
            return super.success(resVO);
        }
        // 完善信息并进行四要素实名认证
        // 是否已完善信息及实名认证
        // 是否为个人
        LitigantInfo litigantInfo = litigantInfoMapper.selectByUserId(dbUser.getUserInfoId());
        if (litigantInfo.getType().equals(LitigantUserTypeEnum.DEFENDANT.getValue())) {
            return super.error("非法操作，用户性质不匹配");
        }
        if (!dto.getIdcardNo().equals(litigantInfo.getCardId())) {
            return super.error("当前手机号已被其他自然人注册");
        }
        //是否已经验证过 0-验证通过 1-验证不通过
        if ("0".equals(litigantInfo.getElementVerifyStatus())) {
            return super.success(resVO);
        }
        
        // 保存用户证件照
        BuzzResultVO<String> saveRet = this.saveCertificationImages(dto, dbUser.getId());
        if (!saveRet.getOk()) {
            return super.error(saveRet.getMessage());
        }
        // 完善信息并实名认证
        ElementVerifyDTO evDTO = new ElementVerifyDTO();
        evDTO.setBankCardId(dto.getBankcardNo());
        evDTO.setCardId(dto.getIdcardNo());
        evDTO.setCardImageCon(dto.getIdcardBase64ImgBack());
        evDTO.setCardImageFront(dto.getIdcardBase64ImgFront());
        evDTO.setJob(dto.getVocation());
        evDTO.setName(dto.getRealName());
        evDTO.setPhoneCode(dto.getSmsVerifyCode());
        evDTO.setPhone(dto.getPhone());
        evDTO.setSex(dto.getSex());
        evDTO.setEthnic(dto.getNation());
        evDTO.setAddress(dto.getAddress());
        evDTO.setEmail(dto.getEmail());
        evDTO.setUserId(dbUser.getUserInfoId());
        ApiResultVO<String> elRet = microSysUserService.elementVerify(evDTO);
        if (!super.isApiExcuteSuccess(elRet)) {
            return super.error(super.getApiExcuteMessage(elRet));
        }
        return super.success(resVO);
    }
    
    /**
     * 因接口需要验证码，强行生成
     * @param phoneNo
     * @param code
     */
    private void setSmsCode(String phoneNo, String code) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(Constant.REG_PWD_SMS_CODE + phoneNo, code);
        stringRedisTemplate.expire(Constant.REG_PWD_SMS_CODE + phoneNo, 2, TimeUnit.MINUTES);
    }
    
    /**
     * 保存用户证件照到文件服务
     * @param dto
     * @param userId
     * @return
     */
    private BuzzResultVO<String> saveCertificationImages(ReqPersonRegisterDTO dto, String userId) {
        // 保存正面照
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, ImageUtil.convertBase64Byte(dto.getIdcardBase64ImgBack()));
        ApiResultVO<String> uploadRet = microFileService.uploadFile(userId, SysEnum.FileBuzzType.USER_CERTIFICATION_IMG.getCode(), upload);
        if (!super.isApiExcuteSuccess(uploadRet)) {
            return super.error("保存身份证背面照失败");
        }
        dto.setIdcardBase64ImgBack(uploadRet.getBody());
        fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
        upload = new MyMultipartFile("uploadFile", fileOrignName, ImageUtil.convertBase64Byte(dto.getIdcardBase64ImgFront()));
        uploadRet = microFileService.uploadFile(userId, SysEnum.FileBuzzType.USER_CERTIFICATION_IMG.getCode(), upload);
        if (!super.isApiExcuteSuccess(uploadRet)) {
            return super.error("保存身份证正面照失败");
        }
        dto.setIdcardBase64ImgFront(uploadRet.getBody());
        return super.success();
    }
}


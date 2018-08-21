package com.zyxy.service.micro.api.service.api;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyxy.common.custom.MyMultipartFile;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.dto.LabourRealNameDTO;
import com.zyxy.common.enums.SysEnum;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.util.ImageUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.dto.ReqUserLabourAuthDTO;
import com.zyxy.service.micro.api.dto.ResUserLabourAuthDTO;
import com.zyxy.service.micro.api.service.micro.SysUserService;

/**
 * 用户人工审核，用于活体认证失败之后的手持身份证上传
 * @author tanquan
 */
@Service
public class UserLabourAuthService extends BaseService<ReqUserLabourAuthDTO, ResUserLabourAuthDTO>{
    
    @Autowired
    private SysUserService microSysUserService;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private MicroFileService microFileService;
    
    @Override
    protected  BuzzResultVO<ResUserLabourAuthDTO> doBuzz(ReqUserLabourAuthDTO dto, String currentIp) {
        SysUser dbUser = sysUserMapper.selectByPrimaryKey(dto.getUserID());
        if (dbUser == null) {
            return super.error("userID不存在");
        }
        if (dbUser.getResourceOrgId() == null || !dbUser.getResourceOrgId().equals(dto.getOrgNo())) {
            return super.error("当前orgNo不存在该userID");
        }
        // 保存用户证件照
        BuzzResultVO<String> saveRet = this.saveCertificationImages(dto, dbUser.getId());
        if (!saveRet.getOk()) {
            return super.error(saveRet.getMessage());
        }
        LabourRealNameDTO formData = new LabourRealNameDTO();
        formData.setUserId(dbUser.getUserInfoId());
        formData.setIdCard(dto.getIdcardInHandImgBase64Str());
        ApiResultVO<String> apiRet = microSysUserService.labourRealName(formData);
        if (!super.isApiExcuteSuccess(apiRet)) {
            return super.error(super.getApiExcuteMessage(apiRet));
        }
        ResUserLabourAuthDTO resDTO = new ResUserLabourAuthDTO();
        return super.success(resDTO);
    }
    
    /**
     * 保存用户证件照到文件服务
     * @param dto
     * @param userId
     * @return
     */
    private BuzzResultVO<String> saveCertificationImages(ReqUserLabourAuthDTO dto, String userId) {
        // 保存正面照
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, ImageUtil.convertBase64Byte(dto.getIdcardInHandImgBase64Str()));
        ApiResultVO<String> uploadRet = microFileService.uploadFile(userId, SysEnum.FileBuzzType.USER_CERTIFICATION_IMG.getCode(), upload);
        if (!super.isApiExcuteSuccess(uploadRet)) {
            return super.error("保存手持身份证照失败");
        }
        dto.setIdcardInHandImgBase64Str(uploadRet.getBody());
        return super.success();
    }
    
}


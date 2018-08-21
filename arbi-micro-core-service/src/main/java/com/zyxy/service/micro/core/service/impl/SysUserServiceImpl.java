package com.zyxy.service.micro.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.common.constants.Constant;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.LoginService;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroThirdService;
import com.zyxy.common.util.IDCardUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.EnterpriseAuthStatusVO;
import com.zyxy.common.vo.FaceIdGetTokenVO;
import com.zyxy.common.vo.LivenessTokenVO;
import com.zyxy.service.micro.core.service.SysUserService;
import com.zyxy.service.micro.core.util.PwdUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 用户密码相关服务
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private LitigantInfoMapper litigantInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private MicroThirdService microThirdService;

    @Autowired
    private FaceAuthRecordMapper faceAuthRecordMapper;

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    @Autowired
    private LabourRealNameAuthRecordMapper labourRealNameAuthRecordMapper;

    @Autowired
    private LoginService loginService;

    @Autowired
    private EnterpriseAuthRecordMapper enterpriseAuthRecordMapper;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public BusiValidResult userRegisterBusiValid(UserRegisterDTO formData) {
        //是否已经存在该用户
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andPhoneEqualTo(formData.getPhone());
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        if (userInfos != null && userInfos.size() > 0) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ALREADY_EXIST);
        }
        //验证码是否正确
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        if (!stringRedisTemplate.hasKey(Constant.REG_PWD_SMS_CODE + formData.getPhone())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.PHONE_VERIFT_CODE_ERROR);
        }
        String redisVal = operations.get(Constant.REG_PWD_SMS_CODE + formData.getPhone());
        if (!formData.getSmsVerifyCode().equals(redisVal)) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.PHONE_VERIFT_CODE_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult userRegisterBusiExecute(UserRegisterDTO formData) {
        UserInfo userInfo = new UserInfo();
        String userId = sequenceService.getCommonID();
        String sysUserId = sequenceService.getCommonID();
        String litigantId = sequenceService.getCommonID();
        userInfo.setId(userId);
        userInfo.setPhone(formData.getPhone());
        userInfo.setCurrentRole(LitigantTypeEnum.PROPESER.getValue());
        userInfo.setCreaterId(userId);
        userInfo.setCreateTime(new Date());
        userInfoMapper.insertSelective(userInfo);

        SysUser sysUser = new SysUser();
        sysUser.setId(sysUserId);
        sysUser.setUserInfoId(userId);
        sysUser.setUserType(SysUserTypeEnum.PARTY.getValue());
        sysUser.setUserName(formData.getPhone());
        sysUser.setUserPwd(PwdUtil.getPwd(formData.getPassword()));
        sysUser.setStatus(0);
        sysUser.setRegisterIp(formData.getIp());
        sysUser.setLoginType(0);
        sysUser.setRealAuth(0);
        sysUser.setBelocked(0);
        sysUser.setCreateId(userId);
        sysUser.setCreateTime(new Date());
        sysUser.setDeletedFlag(0);
        sysUser.setResourceOrgId(formData.getResourceOrgId());
        sysUserMapper.insertSelective(sysUser);

        LitigantInfo litigantInfo = new LitigantInfo();
        litigantInfo.setId(litigantId);
        litigantInfo.setUserId(userId);
        litigantInfo.setType(formData.getType());
        litigantInfo.setCreaterId(userId);
        litigantInfo.setCreateTime(new Date());
        litigantInfoMapper.insertSelective(litigantInfo);
        String login = loginService.login(formData.getPhone(), formData.getPassword(), "PARTY");
        JSONObject jsonObject = JSONObject.parseObject(login);
        return BusiExecuteResult.builderSuccessResult(jsonObject.get("access_token"));
    }

    @Override
    public BusiValidResult elementVerifyBusiValid(ElementVerifyDTO formData) {
        //是否为个人
        LitigantInfo litigantInfo = litigantInfoMapper.selectByUserId(formData.getUserId());
        if (litigantInfo.getType().equals(LitigantUserTypeEnum.DEFENDANT.getValue())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ILLEGAL);
        }
        //是否已经验证过 0-验证通过 1-验证不通过
        if ("0".equals(litigantInfo.getElementVerifyStatus())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ILLEGAL);
        }
        //身份证是否已经被认证
        LitigantInfoExample litigantInfoExample = new LitigantInfoExample();
        litigantInfoExample.createCriteria()
                .andCardIdEqualTo(formData.getCardId());
        List<LitigantInfo> litigantInfos = litigantInfoMapper.selectByExample(litigantInfoExample);
        if (!litigantInfos.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.CARD_ID_EXIST);
        }
        //手机验证码
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(Constant.REG_PWD_SMS_CODE + formData.getPhone())) {
            String redisVal = operations.get(Constant.REG_PWD_SMS_CODE + formData.getPhone());
            if (!formData.getPhoneCode().equals(redisVal)) {
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.PHONE_VERIFT_CODE_ERROR);
            }
        } else {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.PHONE_VERIFT_CODE_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult elementVerifyBusiExecute(ElementVerifyDTO formData) {
        //进行四要素认证
        BankFourElementDTO bankFourElementDTO = new BankFourElementDTO();
        bankFourElementDTO.setCardNo(formData.getBankCardId());
        bankFourElementDTO.setCertType("00");
        bankFourElementDTO.setCertNo(formData.getCardId());
        bankFourElementDTO.setCertName(formData.getName());
        bankFourElementDTO.setPhoneNo(formData.getPhone());
        bankFourElementDTO.setUserId(formData.getUserId());
        ApiResultVO<String> resultVO = microThirdService.verifyBankFourElement(bankFourElementDTO);
        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(resultVO.getHead().getRetCode())) {
            log.info(resultVO.getBody());
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.AUTH_FAIL);
        }
        //写入数据
        LitigantInfo litigantInfo = new LitigantInfo();
        //姓名 litigant_info
        litigantInfo.setCertName(formData.getName());
        litigantInfo.setName(formData.getName());
        //身份证号 litigant_info
        litigantInfo.setCardId(formData.getCardId());
        //生日
        litigantInfo.setBirthday(IDCardUtil.getBirthday(formData.getCardId()));
        //民族
        litigantInfo.setEthnic(formData.getEthnic());
        //银行卡号 litigant_info
        litigantInfo.setBankCard(formData.getBankCardId());
        //银行预留手机号 litigant_info
        litigantInfo.setBankPhone(formData.getPhone());
        //职业 litigant_info
        litigantInfo.setVocation(formData.getJob());
        //住址 litigant_info
        litigantInfo.setAddress(formData.getAddress());
        //身份证正面 litigant_info
        litigantInfo.setCardImageFront(formData.getCardImageFront());
        //身份证反面 litigant_info
        litigantInfo.setCardImageCon(formData.getCardImageCon());

        //四要素认证状态
        litigantInfo.setElementVerifyStatus("0");

        LitigantInfoExample litigantInfoExample = new LitigantInfoExample();
        litigantInfoExample.createCriteria().andUserIdEqualTo(formData.getUserId());
        litigantInfoMapper.updateByExampleSelective(litigantInfo, litigantInfoExample);

        //姓名 user_info
        UserInfo userInfo = new UserInfo();
        userInfo.setName(formData.getName());
        userInfo.setEmail(formData.getEmail());
        //性别 user_info
        userInfo.setSex(formData.getSex());
        //身份证号 user_info
        userInfo.setCardId(formData.getCardId());
        userInfo.setId(formData.getUserId());
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult getFaceTokenBusiValid(String userId) {
        FaceAuthRecordExample example = new FaceAuthRecordExample();
        List<String> status = new ArrayList<>();
        status.add(FaceAuthRecordStatusEnum.SUCCESS.getCode());
        status.add(FaceAuthRecordStatusEnum.FAIL.getCode());
        example.createCriteria()
                .andStatusIn(status)
                .andUserIdEqualTo(userId);
        //如果已经认证失败，则返回无权限
        //如果认证成功过，则返回无权限
        List<FaceAuthRecord> faceAuthRecords = faceAuthRecordMapper.selectByExample(example);
        if (faceAuthRecords != null && faceAuthRecords.size() > 0) {
            for (FaceAuthRecord faceAuthRecord : faceAuthRecords) {
                if (faceAuthRecord.getStatus().equals(FaceAuthRecordStatusEnum.FAIL.getCode())) {
                    //认证失败过
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.FACE_PLUS_BEYOND_ERROR);
                } else {
                    //认证成功过
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
                }
            }
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Value("${faceid.do-liveness.url}")
    private String doLivenessUrl;

    @Value("${faceid.return-url}")
    private String livenessReturnUrl;

    @Value("${faceid.notify-url}")
    private String livenessNotifyUrl;

    @Override
    public BusiExecuteResult<LivenessTokenVO> getFaceTokenBusiExecute(String userId, String returnUrl) {
        /*
         * 重新申请
         */
        //插入记录表
        FaceAuthRecordWithBLOBs faceAuthRecord = new FaceAuthRecordWithBLOBs();
        String commonID = sequenceService.getCommonID();
        faceAuthRecord.setId(commonID);
        faceAuthRecord.setUserId(userId);
        faceAuthRecord.setStatus(FaceAuthRecordStatusEnum.WAIT_VERIFY.getCode());
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        faceAuthRecord.setIdCardName(userInfo.getName());
        faceAuthRecord.setIdCardNum(userInfo.getCardId());
        faceAuthRecordMapper.insertSelective(faceAuthRecord);
        FaceIdDTO face = new FaceIdDTO();
        face.setBizNo(commonID);
        face.setIdCardName(userInfo.getName());
        face.setIdCardNo(userInfo.getCardId());
        face.setNotifyUrl(livenessNotifyUrl);
        face.setReturnUrl(livenessReturnUrl + "?returnUrl=" + returnUrl);
        ApiResultVO<FaceIdGetTokenVO> faceToken = microThirdService.getFaceToken(face);
        FaceIdGetTokenVO body = faceToken.getBody();

        //重新更新token
        faceAuthRecord = new FaceAuthRecordWithBLOBs();
        faceAuthRecord.setId(commonID);
        //如果调用接口出错
        if (body == null || !StringUtils.isBlank(body.getError_message())) {
            log.error(JSONObject.toJSONString(body));
            if (body != null) {
                faceAuthRecord.setGetTokenApiResultInfo(JSONObject.toJSONString(body));
            }
            faceAuthRecord.setStatus(FaceAuthRecordStatusEnum.GET_TOKEN_EXCEPTION.getCode());
            faceAuthRecordMapper.updateByPrimaryKeySelective(faceAuthRecord);
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CALL_THIRD_SERV_ERROR);
        }
        faceAuthRecord.setGetTokenApiResultInfo(JSONObject.toJSONString(body));
        faceAuthRecord.setRequestId(body.getRequest_id());
        faceAuthRecord.setToken(body.getToken());
        faceAuthRecord.setTokenExpiredTime(new Date(System.currentTimeMillis() + body.getExpired_time() * 1000));
        faceAuthRecordMapper.updateByPrimaryKeySelective(faceAuthRecord);
        LivenessTokenVO livenessTokenVO = new LivenessTokenVO();
        livenessTokenVO.setToken(body.getToken());
        livenessTokenVO.setUrl(doLivenessUrl);
        return BusiExecuteResult.builderSuccessResult(livenessTokenVO);
    }

    @Override
    public BusiValidResult labourRealNameBusiValid(LabourRealNameDTO formData) {
        //是否有进行中的
        LabourRealNameAuthRecordExample example = new LabourRealNameAuthRecordExample();
        example.createCriteria()
                .andCreaterIdEqualTo(formData.getUserId())
                .andStatusEqualTo(LabourRealNameAuthRecordStatusEnum.WAIT_AUDIT.getValue());
        List<LabourRealNameAuthRecord> labourRealNameAuthRecords = labourRealNameAuthRecordMapper.selectByExample(example);
        if (labourRealNameAuthRecords != null && labourRealNameAuthRecords.size() > 0) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.LABOUR_REAL_NAME_AUDITING);
        }
        //======================
        //  是否为活体认证失败的
        //======================
        FaceAuthRecordExample failExample = new FaceAuthRecordExample();
        List<String> status = new ArrayList<>();
        status.add(FaceAuthRecordStatusEnum.FAIL.getCode());
        failExample.createCriteria()
                .andStatusIn(status)
                .andUserIdEqualTo(formData.getUserId());
        //如果已经认证失败，则返回无权限
        //如果认证成功过，则返回无权限
        List<FaceAuthRecord> faceAuthRecords = faceAuthRecordMapper.selectByExample(failExample);
        if (faceAuthRecords != null && faceAuthRecords.size() == 0) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FACE_PLUS_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult labourRealNameBusiExecute(LabourRealNameDTO formData) {
        LabourRealNameAuthRecord labourRealNameAuthRecord = new LabourRealNameAuthRecord();
        labourRealNameAuthRecord.setId(sequenceService.getCommonID());
        labourRealNameAuthRecord.setCreaterId(formData.getUserId());
        labourRealNameAuthRecord.setCreateTime(new Date());
        labourRealNameAuthRecord.setIdCard(formData.getIdCard());
        labourRealNameAuthRecord.setStatus(LabourRealNameAuthRecordStatusEnum.WAIT_AUDIT.getValue());
        labourRealNameAuthRecord.setCurrentOwner(caseManagerMapper.queryFreeManagerPeopleByCaseAndType("", ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode()));
        labourRealNameAuthRecordMapper.insertSelective(labourRealNameAuthRecord);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Value("${faceid.appsecret}")
    private String appSecret;

    @Override
    public BusiExecuteResult livenessNotifyBusiExecute(FaceIdNotifyDTO formData) {
        log.info("=======================================================活体验证状态:" + formData.verify(appSecret) + "=========================================================");
        if (formData.verify(appSecret)) {
            log.info("=======================================================data:" + formData.getData() + "=========================================================");
            String data = formData.getData();
            JSONObject dataJson = JSONObject.parseObject(data);
            String bizNo = dataJson.getString("biz_no");
            FaceAuthRecordWithBLOBs record = faceAuthRecordMapper.selectByPrimaryKey(bizNo);
            String status = record.getStatus();
            log.info("=======================================================status:" + status + "=========================================================");
            if (!status.equals(FaceAuthRecordStatusEnum.WAIT_VERIFY.getCode())) {
                return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.ILLEGAL);
            }
            JSONObject livenessResult = dataJson.getObject("liveness_result", JSONObject.class);
            //活体结果
            String livenessResultStr = livenessResult.getString("result");

            //修改对象
            FaceAuthRecordWithBLOBs faceAuthRecordWithBLOBs = new FaceAuthRecordWithBLOBs();
            faceAuthRecordWithBLOBs.setId(bizNo);
            faceAuthRecordWithBLOBs.setCallbackInfo(JSONObject.toJSONString(formData));
            log.info("=======================================================\"success\".equals(livenessResultStr):" + "success".equals(livenessResultStr) + "=========================================================");
            JSONObject verifyResult = dataJson.getObject("verify_result", JSONObject.class);
            if ("success".equals(livenessResultStr) && StringUtils.isBlank(verifyResult.getString("error_message"))) {
                JSONObject resultFaceid = verifyResult.getObject("result_faceid", JSONObject.class);
                //匹配显示度
                Float confidence = resultFaceid.getFloat("confidence");
                JSONObject thresholds = resultFaceid.getObject("thresholds", JSONObject.class);
                //匹配度阈值
                Float compareNum = thresholds.getFloat("1e-4");
                if (confidence.compareTo(compareNum) >= 0) {
                    faceAuthRecordWithBLOBs.setStatus(FaceAuthRecordStatusEnum.SUCCESS.getCode());
                    //修改实名状态
                    SysUserExample example = new SysUserExample();
                    example.createCriteria()
                            .andUserInfoIdEqualTo(record.getUserId());
                    SysUser sysUser = new SysUser();
                    sysUser.setRealAuth(1);
                    sysUserMapper.updateByExampleSelective(sysUser, example);
                } else {
                    faceAuthRecordWithBLOBs.setStatus(FaceAuthRecordStatusEnum.FAIL.getCode());
                }
                faceAuthRecordWithBLOBs.setSimilarity(compareNum);
                faceAuthRecordWithBLOBs.setSimilarityResult(confidence);
            } else {
                faceAuthRecordWithBLOBs.setStatus(FaceAuthRecordStatusEnum.FAIL.getCode());
            }
            faceAuthRecordMapper.updateByPrimaryKeySelective(faceAuthRecordWithBLOBs);
            return BusiExecuteResult.builderSuccessResult();
        } else {
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.ILLEGAL);
        }
    }

    @Override
    public BusiExecuteResult livenessReturnBusiExecute(FaceIdNotifyDTO formData) {
        String data = formData.getData();
        JSONObject dataJson = JSONObject.parseObject(data);
        JSONObject livenessResult = dataJson.getObject("liveness_result", JSONObject.class);
        //活体结果
        String livenessResultStr = livenessResult.getString("result");

        //修改对象
        JSONObject verifyResult = dataJson.getObject("verify_result", JSONObject.class);
        if ("success".equals(livenessResultStr) && StringUtils.isBlank(verifyResult.getString("error_message"))) {
            JSONObject resultFaceid = verifyResult.getObject("result_faceid", JSONObject.class);
            //匹配显示度
            Float confidence = resultFaceid.getFloat("confidence");
            JSONObject thresholds = resultFaceid.getObject("thresholds", JSONObject.class);
            //匹配度阈值
            Float compareNum = thresholds.getFloat("1e-4");
            if (confidence.compareTo(compareNum) >= 0) {
                return BusiExecuteResult.builderSuccessResult();
            } else {
                return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.ERROR);
            }
        } else {
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.ERROR);
        }
    }

    @Override
    public BusiValidResult lostPwdTokenBusiValid(LostPwdTokenDTO formData) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String smsKey = Constant.LOST_PWD_SMS_CODE + formData.getPhone();
        String s = operations.get(smsKey);
        stringRedisTemplate.delete(smsKey);
        if (!formData.getSmsCode().equals(s)) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.PHONE_VERIFT_CODE_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<String> lostPwdTokenBusiExecute(LostPwdTokenDTO formData) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String token = sequenceService.getCommonID();
        Long validMin = 15L;
        operations.set(Constant.LOST_PWD_TOKEN + token, formData.getPhone());
        String smsKey = Constant.LOST_PWD_SMS_CODE + formData.getPhone();
        stringRedisTemplate.expire(smsKey, validMin, TimeUnit.MINUTES);
        return BusiExecuteResult.builderSuccessResult(token);
    }

    @Override
    public BusiValidResult lostPwdBusiValid(LostPwdDTO formData) {
        String tokenKey = Constant.LOST_PWD_TOKEN + formData.getToken();
        if (!stringRedisTemplate.hasKey(tokenKey)) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult lostPwdBusiExecute(LostPwdDTO formData) {
        String tokenKey = Constant.LOST_PWD_TOKEN + formData.getToken();
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String phone = operations.get(tokenKey);
        stringRedisTemplate.delete(tokenKey);
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample
                .createCriteria()
                .andUserNameEqualTo(phone);
        SysUser sysUser = new SysUser();
        sysUser.setUserPwd(PwdUtil.getPwd(formData.getPassWord()));
        int lows = sysUserMapper.updateByExampleSelective(sysUser, sysUserExample);
        if (lows > 0) {
            return BusiExecuteResult.builderSuccessResult();
        } else {
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }
    }

    @Override
    public BusiExecuteResult changeRoleBusiExecute(ChangeRoleDTO form) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(form.getUserId());
        userInfo.setCurrentRole(form.getRole());
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult enterpriseAuthBusiValid(EnterpriseAuthDTO formData) {
        //是否为企业
        LitigantInfo litigantInfo = litigantInfoMapper.selectByUserId(formData.getUserId());
        if (!litigantInfo.getType().equals(LitigantUserTypeEnum.DEFENDANT.getValue())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ILLEGAL);
        }
        EnterpriseAuthRecordExample enterpriseAuthRecordExample = new EnterpriseAuthRecordExample();
        enterpriseAuthRecordExample.createCriteria()
                .andCreaterIdEqualTo(formData.getUserId())
                .andStatusEqualTo("0");
        List<EnterpriseAuthRecord> enterpriseAuthRecords = enterpriseAuthRecordMapper.selectByExample(enterpriseAuthRecordExample);
        if (enterpriseAuthRecords != null && !enterpriseAuthRecords.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ENT_INFO_EXIST);
        }
        enterpriseAuthRecordExample = new EnterpriseAuthRecordExample();
        enterpriseAuthRecordExample.createCriteria()
                .andCreaterIdEqualTo(formData.getUserId())
                .andStatusEqualTo("1");
        enterpriseAuthRecords = enterpriseAuthRecordMapper.selectByExample(enterpriseAuthRecordExample);
        if (enterpriseAuthRecords != null && !enterpriseAuthRecords.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ENT_INFO_SUCCESS);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<BigDecimal> enterpriseAuthBusiExecute(EnterpriseAuthDTO formData) {
        Random random = new Random();
        int i = 0;
        while (i == 0) {
            i = random.nextInt(100);
        }
        BigDecimal amount = new BigDecimal(i);
        amount = amount.divide(new BigDecimal(100));
        EnterpriseAuthRecord enterpriseAuthRecord = new EnterpriseAuthRecord();
        enterpriseAuthRecord.setAddress(formData.getAddress());
        enterpriseAuthRecord.setAmount(amount);
        enterpriseAuthRecord.setCardImageCon(formData.getCardImageCon());
        enterpriseAuthRecord.setCardImageFront(formData.getCardImageFront());
        enterpriseAuthRecord.setCertDuties(formData.getCertDuties());
        enterpriseAuthRecord.setCertName(formData.getCertName());
        enterpriseAuthRecord.setCreaterId(formData.getUserId());
        enterpriseAuthRecord.setCreateTime(new Date());
        enterpriseAuthRecord.setEmail(formData.getEmail());
        enterpriseAuthRecord.setId(sequenceService.getCommonID());
        enterpriseAuthRecord.setName(formData.getName());
        enterpriseAuthRecord.setPlatformAuth(formData.getPlatformAuth());
        enterpriseAuthRecord.setStatus("0");
        enterpriseAuthRecord.setThreeInOne(formData.getThreeInOne());
        enterpriseAuthRecord.setType(formData.getType());
        enterpriseAuthRecord.setUnifiedSocialCode(formData.getUnifiedSocialCode());
        enterpriseAuthRecordMapper.insertSelective(enterpriseAuthRecord);
        return BusiExecuteResult.builderSuccessResult(amount);
    }

    @Override
    public BusiValidResult enterpriseAuthStatusBusiValid(BaseDTO formData) {
        //是否为企业
        LitigantInfo litigantInfo = litigantInfoMapper.selectByUserId(formData.getUserId());
        if (!litigantInfo.getType().equals(LitigantUserTypeEnum.DEFENDANT.getValue())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ILLEGAL);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<EnterpriseAuthStatusVO> enterpriseAuthStatusBusiExecute(BaseDTO formData) {
        EnterpriseAuthStatusVO enterpriseAuthStatusVO = new EnterpriseAuthStatusVO();
        enterpriseAuthStatusVO.setAccount("工商银行 12412412512512612");
        /**
         * 状态。0- 未提交，1- 审核中，2- 审核通过，3- 审核不通过
         */
        //是否未提交审核
        EnterpriseAuthRecordExample enterpriseAuthRecordExample = new EnterpriseAuthRecordExample();
        enterpriseAuthRecordExample.createCriteria()
                .andCreaterIdEqualTo(formData.getUserId());
        List<EnterpriseAuthRecord> enterpriseAuthRecords = enterpriseAuthRecordMapper.selectByExample(enterpriseAuthRecordExample);
        if (enterpriseAuthRecords == null || enterpriseAuthRecords.isEmpty()) {
            enterpriseAuthStatusVO.setStatus("0");
            return BusiExecuteResult.builderSuccessResult(enterpriseAuthStatusVO);
        }
        //是否审核通过
        enterpriseAuthRecordExample = new EnterpriseAuthRecordExample();
        enterpriseAuthRecordExample.createCriteria()
                .andCreaterIdEqualTo(formData.getUserId())
                .andStatusEqualTo("1");
        enterpriseAuthRecords = enterpriseAuthRecordMapper.selectByExample(enterpriseAuthRecordExample);
        if (enterpriseAuthRecords != null && !enterpriseAuthRecords.isEmpty()) {
            enterpriseAuthStatusVO.setStatus("2");
            return BusiExecuteResult.builderSuccessResult(enterpriseAuthStatusVO);
        }
        //是否审核中
        enterpriseAuthRecordExample = new EnterpriseAuthRecordExample();
        enterpriseAuthRecordExample.createCriteria()
                .andCreaterIdEqualTo(formData.getUserId())
                .andStatusEqualTo("0");
        enterpriseAuthRecords = enterpriseAuthRecordMapper.selectByExample(enterpriseAuthRecordExample);
        if (enterpriseAuthRecords != null && !enterpriseAuthRecords.isEmpty()) {
            enterpriseAuthStatusVO.setStatus("1");
            enterpriseAuthStatusVO.setAmount(enterpriseAuthRecords.get(0).getAmount());
            return BusiExecuteResult.builderSuccessResult(enterpriseAuthStatusVO);
        }

        //审核不通过
        enterpriseAuthStatusVO.setStatus("3");
        return BusiExecuteResult.builderSuccessResult(enterpriseAuthStatusVO);
    }
}

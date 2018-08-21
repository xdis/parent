package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.EnterpriseAuthStatusVO;
import com.zyxy.common.vo.LivenessTokenVO;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 用户服务
 */
public interface SysUserService {
	
    /**
     * 用户注册业务验证
     * @param formData
     * @return
     */
	BusiValidResult userRegisterBusiValid(UserRegisterDTO formData);
    
    
    /**
     * 用户注册业务处理
     * @param formData
     * @return
     */
    @Transactional
    BusiExecuteResult userRegisterBusiExecute(UserRegisterDTO formData);

    /**
     * 四要素业务验证
     * @param formData
     * @return
     */
	BusiValidResult elementVerifyBusiValid(ElementVerifyDTO formData);


    /**
     * 四要素业务处理
     * @param formData
     * @return
     */
    @Transactional
    BusiExecuteResult elementVerifyBusiExecute(ElementVerifyDTO formData);

    /**
     * 获取face++token业务验证
     * @param userId 用户Id
     * @return
     */
	BusiValidResult getFaceTokenBusiValid(String userId);


    /**
     * 获取face++token业务处理
     * @param userId 用户Id
     * @return
     */
    @Transactional
    BusiExecuteResult<LivenessTokenVO> getFaceTokenBusiExecute(String userId, String returnUrl);

    /**
     * 提交人工实名认证业务验证
     *
     * @param formData 人工审核DTO
     * @return
     */
    BusiValidResult labourRealNameBusiValid(LabourRealNameDTO formData);


    /**
     * 提交人工实名认证业务处理
     *
     * @param formData 人工审核DTO
     * @return
     */
    @Transactional
    BusiExecuteResult labourRealNameBusiExecute(LabourRealNameDTO formData);

    /**
     * 提交企业认证业务验证
     *
     * @param formData 人工审核DTO
     * @return
     */
    BusiValidResult enterpriseAuthBusiValid(EnterpriseAuthDTO formData);


    /**
     * 提交企业认证业务处理
     *
     * @param formData 人工审核DTO
     * @return
     */
    @Transactional
    BusiExecuteResult<BigDecimal> enterpriseAuthBusiExecute(EnterpriseAuthDTO formData);

    /**
     * 企业认证状态业务验证
     *
     * @param formData 人工审核DTO
     * @return
     */
    BusiValidResult enterpriseAuthStatusBusiValid(BaseDTO formData);


    /**
     * 企业认证状态业务处理
     *
     * @param formData 人工审核DTO
     * @return
     */
    @Transactional
    BusiExecuteResult<EnterpriseAuthStatusVO> enterpriseAuthStatusBusiExecute(BaseDTO formData);

    /**
     * face回调业务处理
     * @return
     */
    BusiExecuteResult livenessNotifyBusiExecute(FaceIdNotifyDTO form);

    /**
     * face回调业务处理
     * @return
     */
    @Transactional
    BusiExecuteResult livenessReturnBusiExecute(FaceIdNotifyDTO form);

    /**
     * 得到修改密码Token
     *
     * @return
     */
    BusiValidResult lostPwdTokenBusiValid(LostPwdTokenDTO form);

    /**
     * 得到修改密码Token
     *
     * @return
     */
    @Transactional
    BusiExecuteResult<String> lostPwdTokenBusiExecute(LostPwdTokenDTO form);

    /**
     * 找回密码-修改密码
     *
     * @return
     */
    BusiValidResult lostPwdBusiValid(LostPwdDTO form);

    /**
     * 找回密码-修改密码
     *
     * @return
     */
    @Transactional
    BusiExecuteResult lostPwdBusiExecute(LostPwdDTO form);

    /**
     * 切换角色
     *
     * @return
     */
    @Transactional
    BusiExecuteResult changeRoleBusiExecute(ChangeRoleDTO form);

}

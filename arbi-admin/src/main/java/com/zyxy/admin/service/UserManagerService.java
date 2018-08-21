package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.ArbitrationUserInfoDTO;
import com.zyxy.common.dto.UserManagerArbiUserInfoDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ArbitrationUserInfoVO;

/**
 * 仲裁委后台用户管理
 */
public interface UserManagerService {


    BusiValidResult arbiUserManagerBusiValidResult();

    /**
     * 查询仲裁委后台管理用户列表业务处理
     * @param formData
     * @return
     */
    BusiExecuteResult<PageInfo<ArbitrationUserInfoVO>> arbiUserManagerBusiExecuteResult(ArbitrationUserInfoDTO formData);

    /**
     * 仲裁委后台用户重置密码业务验证
     * @param userId
     * @return
     */
    BusiValidResult resetPwdBusiValidResult(String userId);


    /**
     * 仲裁委后台用户重置密码业务处理
     * @param userId
     * @return
     */
    BusiExecuteResult resetPwdBusiExecuteResult(String userId);


    /**
     * 仲裁委后台用户启用账号业务验证
     * @param userId
     * @return
     */
    BusiValidResult enableStatusBusiValidResult(String userId);

    /**
     * 仲裁委后台用户启用账号业务处理
     * @param userId
     * @return
     */
    BusiExecuteResult enableStatusBusiExecuteResult(String userId);
    /**
     * 仲裁委后台用户禁用账号业务验证
     * @param userId
     * @return
     */
    BusiValidResult disableStatusBusiValidResult(String userId);

    /**
     * 仲裁委后台用户禁用账号业务处理
     * @param userId
     * @return
     */
    BusiExecuteResult disableStatusBusiExecuteResult(String userId);


    /**
     * 添加仲裁委账号业务验证
     * @param formData
     * @return
     */
    BusiValidResult addArbiBusiValidResult(UserManagerArbiUserInfoDTO formData);

    /**
     * 添加仲裁委账号业务验证
     * @param formData
     * @return
     */
    BusiExecuteResult addArbiBusiExecuteResult(UserManagerArbiUserInfoDTO formData);
}

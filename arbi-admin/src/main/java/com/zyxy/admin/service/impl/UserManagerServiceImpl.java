package com.zyxy.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.UserManagerService;
import com.zyxy.admin.util.PwdUtil;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.ArbitrationUserInfoDTO;
import com.zyxy.common.dto.UserManagerArbiUserInfoDTO;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitrationUserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 仲裁委后台用户管理
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ManagerInfoMapper managerInfoMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public BusiValidResult arbiUserManagerBusiValidResult() {
        return null;
    }

    /**
     * 查询仲裁委后台管理用户列表业务处理
     * @param formData
     * @return
     */
    @Override
    public BusiExecuteResult<PageInfo<ArbitrationUserInfoVO>> arbiUserManagerBusiExecuteResult(ArbitrationUserInfoDTO formData) {

        //账号和仲裁委工作人员的状态必须保持一致
        if(!StringUtil.isEmpty(formData.getSysStatus())){
            if(SysUserStatusEnum.NORMAL.getCode().equals(formData.getSysStatus())){
                formData.setManagerStatus(ManagerInfoStatusEnum.NORMAL.getCode());
            }else{
                formData.setManagerStatus(ManagerInfoStatusEnum.CANCELLATION.getCode());
            }
        }

        PageInfo<ArbitrationUserInfoVO> arbitrationUserInfoVOPageInfo = this.arbiUserManager(formData);
        return BusiExecuteResult.builderSuccessResult(arbitrationUserInfoVOPageInfo);
    }

    /**
     * 仲裁委后台用户重置密码业务验证
     * @param userId
     * @return
     */
    @Override
    public BusiValidResult resetPwdBusiValidResult(String userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if(userInfo==null){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserInfoIdEqualTo(userId).andStatusEqualTo(Integer.parseInt(SysUserStatusEnum.NORMAL.getCode()));
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        if(sysUserList.size()<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ACCOUNT_ERROR);
        }

        ManagerInfoExample managerInfoExample = new ManagerInfoExample();
        managerInfoExample.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(ManagerInfoStatusEnum.NORMAL.getCode());
        List<ManagerInfo> managerInfoList = managerInfoMapper.selectByExample(managerInfoExample);

        if(managerInfoList.size()<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ACCOUNT_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 仲裁委后台用户重置密码业务处理
     * @param userId
     * @return
     */
    @Override
    public BusiExecuteResult resetPwdBusiExecuteResult(String userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if(StringUtil.isEmpty(userInfo.getPhone())){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.PHONE_IS_NULL);
        }
        //取手机号后六位作为新密码并加密
        String newPwd = PwdUtil.getPwd(userInfo.getPhone().substring(userInfo.getPhone().length()-6,userInfo.getPhone().length()));

        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserInfoIdEqualTo(userId);
        SysUser sysUser = new SysUser();
        sysUser.setUserPwd(newPwd);
        int i = sysUserMapper.updateByExampleSelective(sysUser, sysUserExample);
        if(i<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }

        return BusiExecuteResult.builderSuccessResult();
    }

    /**
     * 仲裁委后台用户启用账号业务验证
     * @param userId
     * @return
     */
    @Override
    public BusiValidResult enableStatusBusiValidResult(String userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if(userInfo==null){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserInfoIdEqualTo(userId);
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        if(sysUserList.size()<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        ManagerInfoExample managerInfoExample = new ManagerInfoExample();
        managerInfoExample.createCriteria().andUserIdEqualTo(userId);
        List<ManagerInfo> managerInfoList = managerInfoMapper.selectByExample(managerInfoExample);

        if(managerInfoList.size()<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 仲裁委后台用户启用账号业务处理
     * @param userId
     * @return
     */
    @Override
    public BusiExecuteResult enableStatusBusiExecuteResult(String userId) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserInfoIdEqualTo(userId);
        SysUser sysUser = new SysUser();
        sysUser.setStatus(Integer.parseInt(SysUserStatusEnum.NORMAL.getCode()));
        int i = sysUserMapper.updateByExampleSelective(sysUser, sysUserExample);
        if(i<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }

        ManagerInfoExample managerInfoExample = new ManagerInfoExample();
        managerInfoExample.createCriteria().andUserIdEqualTo(userId);
        ManagerInfo managerInfo = new ManagerInfo();
        managerInfo.setStatus(ManagerInfoStatusEnum.NORMAL.getCode());
        int l = managerInfoMapper.updateByExampleSelective(managerInfo, managerInfoExample);

        if(l<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }

        return BusiExecuteResult.builderSuccessResult();
    }


    /**
     * 仲裁委后台用户启用账号业务验证
     * @param userId
     * @return
     */
    @Override
    public BusiValidResult disableStatusBusiValidResult(String userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if(userInfo==null){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserInfoIdEqualTo(userId);
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        if(sysUserList.size()<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        ManagerInfoExample managerInfoExample = new ManagerInfoExample();
        managerInfoExample.createCriteria().andUserIdEqualTo(userId);
        List<ManagerInfo> managerInfoList = managerInfoMapper.selectByExample(managerInfoExample);

        if(managerInfoList.size()<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 仲裁委后台用户启用账号业务处理
     * @param userId
     * @return
     */
    @Override
    public BusiExecuteResult disableStatusBusiExecuteResult(String userId) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserInfoIdEqualTo(userId);
        SysUser sysUser = new SysUser();
        sysUser.setStatus(Integer.parseInt(SysUserStatusEnum.DISABLE.getCode()));
        int i = sysUserMapper.updateByExampleSelective(sysUser, sysUserExample);
        if(i<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }

        ManagerInfoExample managerInfoExample = new ManagerInfoExample();
        managerInfoExample.createCriteria().andUserIdEqualTo(userId);
        ManagerInfo managerInfo = new ManagerInfo();
        managerInfo.setStatus(ManagerInfoStatusEnum.CANCELLATION.getCode());
        int l = managerInfoMapper.updateByExampleSelective(managerInfo, managerInfoExample);

        if(l<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }

        return BusiExecuteResult.builderSuccessResult();
    }

    /**
     * 添加仲裁委账号业务验证
     * @param formData
     * @return
     */
    @Override
    public BusiValidResult addArbiBusiValidResult(UserManagerArbiUserInfoDTO formData) {
        if(!formData.getPwd().equals(formData.getConfirmPwd())){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.PASSWORDS_NOT_MATCH);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 添加仲裁委账号业务验证
     * @param formData
     * @return
     */
    @Override
    public BusiExecuteResult addArbiBusiExecuteResult(UserManagerArbiUserInfoDTO formData) {
        String pwd = PwdUtil.getPwd(formData.getPwd());

        String userId = sequenceService.getCommonID();

        UserInfo userInfo = new UserInfo();
        Date date = new Date();
        userInfo.setId(userId);
        userInfo.setPhone(formData.getPhone());
        userInfo.setName(formData.getUserName());
        userInfo.setCreaterId(formData.getCreaterId());
        userInfo.setCreateTime(date);

        int userInfoLow = userInfoMapper.insertSelective(userInfo);

        String sysUserId = sequenceService.getCommonID();

        SysUser sysUser = new SysUser();
        sysUser.setId(sysUserId);
        sysUser.setUserInfoId(userId);
        sysUser.setUserType(SysUserTypeEnum.ARBITRATION_COMMITTEE.getValue());
        sysUser.setUserName(formData.getAccount());
        sysUser.setUserPwd(pwd);
        sysUser.setStatus(Integer.parseInt(SysUserStatusEnum.NORMAL.getCode()));
        sysUser.setBelocked(Integer.parseInt(SysUserBelockedEnum.NO.getCode()));
        sysUser.setCreateId(formData.getCreaterId());
        sysUser.setCreateTime(date);

        int sysUserLow = sysUserMapper.insertSelective(sysUser);

        ManagerInfoTypeEnum managerInfoTypeEnum = ManagerInfoTypeEnum.getCode(formData.getDuties());
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andStatusEqualTo(Integer.parseInt(SysRoleStatusEnum.NORMAL.getCode())).andRoleNameEqualTo(managerInfoTypeEnum.getMark());
        List<SysRole> sysRoleList = sysRoleMapper.selectByExample(sysRoleExample);
        if(sysRoleList.size()<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        String roleId = sysRoleList.get(0).getId();

        String sysUserRoleId = sequenceService.getCommonID();

        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setId(sysUserRoleId);
        sysUserRole.setUserId(userId);
        sysUserRole.setRoleId(roleId);
        sysUserRole.setCreateId(formData.getCreaterId());
        sysUserRole.setCreateTime(date);

        int sysUserRoleLow = sysUserRoleMapper.insertSelective(sysUserRole);


        ManagerInfo managerInfo = new ManagerInfo();
        managerInfo.setDuties(formData.getDuties());
        managerInfo.setStatus(ManagerInfoStatusEnum.NORMAL.getCode());
        managerInfo.setCreaterId(formData.getCreaterId());
        managerInfo.setCreateDate(DateUtil.getDate("yyyyMMdd"));
        managerInfo.setCreateTime(DateUtil.getDate("HHmmss"));
        managerInfo.setUserId(userId);
        int managerInfoLow = managerInfoMapper.insertSelective(managerInfo);
        if(userInfoLow<=0&&sysUserLow<=0&&sysUserRoleLow<=0&&managerInfoLow<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
        }
        return BusiExecuteResult.builderSuccessResult();
    }

    /*********私有service********/

    /**
     * 查询仲裁委后台管理用户列表
     * @param formData
     * @return
     */
    private PageInfo<ArbitrationUserInfoVO> arbiUserManager(ArbitrationUserInfoDTO formData){
        if (formData.getPageNum() == null || formData.getPageNum() < 1) {
            formData.setPageNum(1);
        }
        if (formData.getPageSize() == null || formData.getPageSize() < 1
                || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
        PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
        return new PageInfo<ArbitrationUserInfoVO>(sysUserMapper.selectArbitrationUserInfo(formData));
    }
}

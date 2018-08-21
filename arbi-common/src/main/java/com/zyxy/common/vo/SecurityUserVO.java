package com.zyxy.common.vo;

import com.zyxy.common.domain.SysRole;
import com.zyxy.common.domain.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecurityUserVO extends SysUser implements UserDetails {
    private static final long serialVersionUID = -8583172581806649618L;
    private Set<GrantedAuthority> authorities;
    private List<SysRole> roleList;
    /**
     * 当前用户身份,0-申请人,1-被申请人,2-代理人
     */
    private String currentRole;

    /**
     * 四要素验证状态0- 通过,1- 未通过
     */
    private String elementVerifyStatus;

    /**
     * 当事人类型,0-个人,1-企业
     */
    private String litigantInfoType;

    public SecurityUserVO() {
    }

    public SecurityUserVO(SysUser sysUser) {
        this.setId(sysUser.getId());
        this.setUserInfoId(sysUser.getUserInfoId());
        this.setUserType(sysUser.getUserType());
        this.setUserName(sysUser.getUserName());
        this.setUserPwd(sysUser.getUserPwd());
        this.setStatus(sysUser.getStatus());
        this.setRegisterIp(sysUser.getRegisterIp());
        this.setLoginTimes(sysUser.getLoginTimes());
        this.setLastLoginIp(sysUser.getLastLoginIp());
        this.setLastLoginTime(sysUser.getLastLoginTime());
        this.setLastSelectRole(sysUser.getLastSelectRole());
        this.setNickName(sysUser.getNickName());
        this.setHeadphoto(sysUser.getHeadphoto());
        this.setLoginType(sysUser.getLoginType());
        this.setRealAuth(sysUser.getRealAuth());
        this.setPwdWrongTimes(sysUser.getPwdWrongTimes());
        this.setBelocked(sysUser.getBelocked());
        this.setCurrThirdOauthId(sysUser.getCurrThirdOauthId());
        this.setCreateId(sysUser.getCreateId());
        this.setUpdateId(sysUser.getUpdateId());
        this.setCreateTime(sysUser.getCreateTime());
        this.setUpdateTime(sysUser.getUpdateTime());
        this.setDeletedFlag(sysUser.getDeletedFlag());
        this.authorities = new HashSet<>();
    }

    @Override
    public String getPassword() {
        return this.getUserPwd();
    }

    @Override
    public String getUsername() {
        return this.getUserName();
    }

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public String getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

    public String getElementVerifyStatus() {
        return elementVerifyStatus;
    }

    public void setElementVerifyStatus(String elementVerifyStatus) {
        this.elementVerifyStatus = elementVerifyStatus;
    }

    public String getLitigantInfoType() {
        return litigantInfoType;
    }

    public void setLitigantInfoType(String litigantInfoType) {
        this.litigantInfoType = litigantInfoType;
    }
}

package com.zyxy.auth.security.service;

import com.zyxy.auth.service.LitigantInfoService;
import com.zyxy.auth.service.SysResourceService;
import com.zyxy.auth.service.SysRoleService;
import com.zyxy.auth.service.SysUserService;
import com.zyxy.auth.service.UserInfoService;
import com.zyxy.common.domain.LitigantInfo;
import com.zyxy.common.domain.SysRole;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.enums.CacheTypeEnum;
import com.zyxy.common.exception.BuzzException;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.vo.SecurityUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DBUserDetailsServiceImpl implements UserDetailsService {
    private MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LitigantInfoService litigantInfoService;

    @Autowired
    private CacheService cacheService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getByUserName(userName);
        if (sysUser == null) {
            throw new UsernameNotFoundException(userName);
        }

        return getSecurityUserVO(sysUser);
    }

    public UserDetails loadUserByUsername(String userName, int userType) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getByUserName(userName, userType);
        if (sysUser == null) {
            throw new UsernameNotFoundException(userName);
        }

        return getSecurityUserVO(sysUser);
    }

    private SecurityUserVO getSecurityUserVO(SysUser sysUser) {
        SecurityUserVO securityUserVO = new SecurityUserVO(sysUser);
        String userInfoId = securityUserVO.getUserInfoId();

        //获取用户拥有资源菜单code
        Set<GrantedAuthority> authorities = securityUserVO.getAuthorities();
        List<String> codeSet = sysResourceService.listAllCodeByUserId(userInfoId);
        for (String code : codeSet) {
            authorities.add(new SimpleGrantedAuthority(code));
        }

        //获取用户拥有角色
        List<SysRole> roleList = sysRoleService.listRoleByUserId(userInfoId);
        securityUserVO.setRoleList(roleList);

        UserInfo userInfo = userInfoService.getById(userInfoId);
        if (userInfo != null) {
            String currentRole = userInfo.getCurrentRole();
            securityUserVO.setCurrentRole(currentRole);
        }

        LitigantInfo litigantInfo = litigantInfoService.getByUserId(userInfoId);
        if (litigantInfo != null) {
            String elementVerifyStatus = litigantInfo.getElementVerifyStatus();
            securityUserVO.setElementVerifyStatus(elementVerifyStatus);
            securityUserVO.setLitigantInfoType(litigantInfo.getType());
        }
        return securityUserVO;
    }

    public UserDetails loadUserByApiSsoToken(String userId, String token) {
        Object apiSsoToken = cacheService.getCache(CacheTypeEnum.API_SSO_TOKEN, userId);
        if (apiSsoToken == null) {
            throw new BuzzException("API_SSO_TOKEN not found in redis");
        }
        if (!apiSsoToken.toString().equalsIgnoreCase(token)) {
            throw new BuzzException("request token is failure");
        }
        SysUser sysUser = sysUserService.getById(userId);
        if (sysUser == null) {
            throw new UsernameNotFoundException("userId not found user");
        }
        return getSecurityUserVO(sysUser);
    }
}

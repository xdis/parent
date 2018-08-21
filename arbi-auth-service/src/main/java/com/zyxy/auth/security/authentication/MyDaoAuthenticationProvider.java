package com.zyxy.auth.security.authentication;

/*
 * Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.zyxy.auth.security.service.DBUserDetailsServiceImpl;
import com.zyxy.common.constants.Constant;
import com.zyxy.common.enums.SysUserTypeEnum;
import com.zyxy.common.exception.BuzzException;
import com.zyxy.common.util.StringUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * An {@link AuthenticationProvider} implementation that retrieves user details from a
 * {@link UserDetailsService}.
 *
 * @author Ben Alex
 * @author Rob Winch
 */
@SuppressWarnings({"AliDeprecation", "deprecation"})
public class MyDaoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    // ~ Static fields/initializers
    // =====================================================================================

    public static final String AUTH_TOKEN = "auth_token";
    public static final String API_SSO_TOKEN_CHECK = "API_SSO_TOKEN_CHECK";
    /**
     * The plaintext password used to perform
     * {@link PasswordEncoder#isPasswordValid(String, String, Object)} on when the user is
     * not found to avoid SEC-2056.
     */
    private static final String USER_NOT_FOUND_PASSWORD = "userNotFoundPassword";

    // ~ Instance fields
    // ================================================================================================
    private PasswordEncoder passwordEncoder;

    /**
     * The password used to perform
     * {@link PasswordEncoder#isPasswordValid(String, String, Object)} on when the user is
     * not found to avoid SEC-2056. This is necessary, because some
     * {@link PasswordEncoder} implementations will short circuit if the password is not
     * in a valid format.
     */
    private String userNotFoundEncodedPassword;

    private SaltSource saltSource;

    private DBUserDetailsServiceImpl userDetailsService;

    private StringRedisTemplate stringRedisTemplate;

    public MyDaoAuthenticationProvider() {
        setPasswordEncoder(new PlaintextPasswordEncoder());
    }

    // ~ Methods
    // ========================================================================================================

    @Override
    @SuppressWarnings("deprecation")
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        Map details = (Map) authentication.getDetails();
        if (details.containsKey(API_SSO_TOKEN_CHECK)) {
            return;
        }

        Object salt = null;

        if (this.saltSource != null) {
            salt = this.saltSource.getSalt(userDetails);
        }

        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }

        String presentedPassword = authentication.getCredentials().toString();

        if (!passwordEncoder.isPasswordValid(userDetails.getPassword(),
                presentedPassword, salt)) {
            logger.debug("Authentication failed: password does not match stored value");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
    }

    @Override
    protected void doAfterPropertiesSet() throws Exception {
        Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
    }

    @Override
    protected final UserDetails retrieveUser(String username,
            UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        UserDetails loadedUser;
        Object detailsObj = authentication.getDetails();
        Object credentials = authentication.getCredentials();
        int userType;
        String loginType;
        Map details;

        //如果detail不是map，直接异常
        if (!(detailsObj instanceof Map)) {
            throw new BuzzException("用户登录信息错误");
        }

        details = (Map) detailsObj;
        loginType = (String) details.get("login_type");

        //获取登录用户类型
        String userTypeStr = (String) details.get("user_type");
        if (StringUtil.isEmpty(userTypeStr)) {
            throw new BuzzException("用户类型不能为空");
        }
        SysUserTypeEnum userTypeEnum = SysUserTypeEnum.getByValue(userTypeStr.toUpperCase());
        if (userTypeEnum == null) {
            throw new BuzzException("用户类型必须指定");
        }
        userType = userTypeEnum.getValue();

        //获取图片验证码
        String imgCode = (String) details.get("img_code");
        if (userType != SysUserTypeEnum.ARBITRATION_COMMITTEE.getValue()) {
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

            String key = Constant.LOGIN_IMG_CODE + username;
            String imgCodeInCache = operations.get(key);

            stringRedisTemplate.delete(key);

            //如果是仲裁员登录，必须验证手机验证码
            if (StringUtil.isEmpty(imgCode)) {
                throw new BuzzException("图形验证码不能为空");
            }

            if (StringUtil.isEmpty(imgCodeInCache) || !imgCode.equalsIgnoreCase(imgCodeInCache)) {
                throw new BuzzException("图形验证码不符");
            }
        }

        try {
            if (AUTH_TOKEN.equalsIgnoreCase(loginType)) {
                details.put(API_SSO_TOKEN_CHECK, true);
                loadedUser = this.getUserDetailsService().loadUserByApiSsoToken(username,
                        credentials != null ? credentials.toString() : "");
            } else {
                loadedUser = this.getUserDetailsService().loadUserByUsername(username, userType);
            }
        } catch (UsernameNotFoundException notFound) {
            if (credentials != null) {
                String presentedPassword = credentials.toString();
                passwordEncoder.isPasswordValid(userNotFoundEncodedPassword,
                        presentedPassword, null);
            }
            throw notFound;
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(
                    repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException(
                    "UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

    /**
     * Sets the PasswordEncoder instance to be used to encode and validate passwords. If
     * not set, the password will be compared as plain text.
     * <p>
     * For systems which are already using salted password which are encoded with a
     * previous release, the encoder should be of type
     * {@code org.springframework.security.authentication.encoding.PasswordEncoder}.
     * Otherwise, the recommended approach is to use
     * {@code org.springframework.security.crypto.password.PasswordEncoder}.
     *
     * @param passwordEncoder must be an instance of one of the {@code PasswordEncoder}
     *                        types.
     */
    public void setPasswordEncoder(Object passwordEncoder) {
        Assert.notNull(passwordEncoder, "passwordEncoder cannot be null");

        if (passwordEncoder instanceof PasswordEncoder) {
            setPasswordEncoder((PasswordEncoder) passwordEncoder);
            return;
        }

        if (passwordEncoder instanceof org.springframework.security.crypto.password.PasswordEncoder) {
            final org.springframework.security.crypto.password.PasswordEncoder delegate = (org.springframework.security.crypto.password.PasswordEncoder) passwordEncoder;
            setPasswordEncoder(new PasswordEncoder() {
                @Override
                public String encodePassword(String rawPass, Object salt) {
                    checkSalt(salt);
                    return delegate.encode(rawPass);
                }

                @Override
                public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
                    checkSalt(salt);
                    return delegate.matches(rawPass, encPass);
                }

                private void checkSalt(Object salt) {
                    Assert.isNull(salt,
                            "Salt value must be null when used with crypto module PasswordEncoder");
                }
            });

            return;
        }

        throw new IllegalArgumentException(
                "passwordEncoder must be a PasswordEncoder instance");
    }

    protected PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        Assert.notNull(passwordEncoder, "passwordEncoder cannot be null");

        this.userNotFoundEncodedPassword = passwordEncoder.encodePassword(
                USER_NOT_FOUND_PASSWORD, null);
        this.passwordEncoder = passwordEncoder;
    }

    protected SaltSource getSaltSource() {
        return saltSource;
    }

    /**
     * The source of salts to use when decoding passwords. <code>null</code> is a valid
     * value, meaning the <code>MyDaoAuthenticationProvider</code> will present
     * <code>null</code> to the relevant <code>PasswordEncoder</code>.
     * <p>
     * Instead, it is recommended that you use an encoder which uses a random salt and
     * combines it with the password field. This is the default approach taken in the
     * {@code org.springframework.security.crypto.password} package.
     *
     * @param saltSource to use when attempting to decode passwords via the
     *                   <code>PasswordEncoder</code>
     */
    public void setSaltSource(SaltSource saltSource) {
        this.saltSource = saltSource;
    }

    protected DBUserDetailsServiceImpl getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(DBUserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}

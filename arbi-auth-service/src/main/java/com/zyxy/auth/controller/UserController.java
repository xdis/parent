package com.zyxy.auth.controller;


import com.zyxy.common.web.BaseController;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    /**
     * 获取当前用户及其他信息
     *
     * @param principal
     * @return
     */
    @GetMapping(value = "/current")
    public Principal getOauth2Authentication(Principal principal) {
        return principal;
    }

    /**
     * 获取当前用户信息
     *
     * @param principal
     * @return
     */
    @GetMapping(value = "/current/principal")
    public Object getUserInfo(Principal principal) {
        if (Authentication.class.isAssignableFrom(principal.getClass())) {
            return ((Authentication) principal).getPrincipal();
        }
        return principal;
    }
}

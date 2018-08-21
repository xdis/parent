package com.zyxy.common.service;

import com.zyxy.common.util.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Value("${security.oauth2.client.accessTokenUri:}")
    private String loginUrl;

    public String login(String username, String password,
            String userType) {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Basic YnJvd3Nlcjo=");
        header.put("Content-Type", "application/x-www-form-urlencoded");

        Map<String, String> params = new HashMap<>();
        params.put("scope", "ui");
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", password);
        params.put("user_type", userType);
        return HttpUtil.sendPost(loginUrl, params, header);
    }
}

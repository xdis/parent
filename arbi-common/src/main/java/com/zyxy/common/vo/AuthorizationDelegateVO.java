package com.zyxy.common.vo;

/**
 * 授权返回
 */
public class AuthorizationDelegateVO {
    /**
     * 授权类型
     * 0 被授权方
     * 1 授权方
     */
    private String authorizationType;
    /**
     * 授权方职务
     */
    private String authorizationDuties;

    /**
     * 授权方用户id
     */
    private String authorizationUserId;

    public String getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(String authorizationType) {
        this.authorizationType = authorizationType;
    }

    public String getAuthorizationDuties() {
        return authorizationDuties;
    }

    public void setAuthorizationDuties(String authorizationDuties) {
        this.authorizationDuties = authorizationDuties;
    }

    public String getAuthorizationUserId() {
        return authorizationUserId;
    }

    public void setAuthorizationUserId(String authorizationUserId) {
        this.authorizationUserId = authorizationUserId;
    }
}

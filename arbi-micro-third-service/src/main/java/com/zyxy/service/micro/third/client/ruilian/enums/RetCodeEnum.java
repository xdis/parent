package com.zyxy.service.micro.third.client.ruilian.enums;

public enum RetCodeEnum {
    SUCCESS("100", "成功"),
    NO_LOGIN("202", "未登录"),
    BIZ_ERROR_211("211", "查询错误"),
    ERROR("299", "系统错误");
    
    private String code;
    
    private String message;
    
    private RetCodeEnum(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

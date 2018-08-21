package com.zyxy.service.micro.third.client.ruilian.enums;

public enum PayStatusEnum {
    CANCLE(0, "已被取消"),
    CREATED(1, "创建"),
    PAYED(2, "已被缴费");
    
    private Integer code;
    
    private String message;
    
    private PayStatusEnum(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

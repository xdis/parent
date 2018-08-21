package com.zyxy.service.micro.api.enums;

public enum ApiCodeEnum {
    SUCCESS("0000","成功"),
    UNKNOWN_ORGANIZATION("0001","未知机构/用户，请确认orgNo的有效性"),
    UNKNOWN_HOST_IP("0002","未知的Host或IP（Host或IP不在白名单内）"),
    DECRYPT_ERROR("0003","参数解密失败（请确认参数已加密或加密算法的准确性）"),
    SIGN_ERROR("0004","验签失败"),
    REQ_PARAM_ILLEGAL("0005","参数非法（不完整,格式非法等）"),
    BIZZ_EXCUTE_FAILED("4999", "业务处理失败，详见message"),
    OP_TOO_OFTEN("9000", "操作频繁"),
    NOT_FOUND("9990", "数据不存在"),
    REQ_ERROR("9997", "非法的请求"),
    ILLEGAL("9998", "非法操作"),
    ERROR("9999", "系统内部错误");
    private String code;
    private String message;
    private ApiCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public String getCode() {
        return code;
    }
    public ApiCodeEnum setCode(String code) {
        this.code = code;
        return this;
    }
    public String getMessage() {
        return message;
    }
    public ApiCodeEnum setMessage(String message) {
        this.message = message;
        return this;
    }
    
    public static  String getCoderStr() {
        StringBuffer sb = new StringBuffer();
        sb.append("[").append("\n");
        int i = 0;
        for (ApiCodeEnum coder : ApiCodeEnum.values()) {
            if (i != 0) {
                sb.append(",\n");
            }
            sb.append("{code : ").append(coder.getCode()).append(", msg : ").append(coder.getMessage()).append("}");
            i++;
        }
        sb.append("\n").append("]");
        return sb.toString();
    }
}

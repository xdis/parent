package com.zyxy.common.vo;

import java.io.Serializable;

/**
 *
 */
public class ResultVO implements Serializable {

    private static final long serialVersionUID = 1L;
    public static enum Result {

        SUCCESS_CODE("0000"),
        SUCCESS_MESSAGE("成功"),

        LOGIN_ERROR_CODE("1999"),
        LOGIN_ERROR_MESSAGE("登录错误"),

        ALREADY_EXIST_CODE("2000"),
        ALREADY_EXIST_MESSAGE("记录已存在"),

        DB_INSERT_ERROR_CODE("2001"),
        DB_INSERT_ERROR_MESSAGE("写入数据失败"),

        DB_UPDATE_ERROR_CODE("2002"),
        DB_UPDATE_ERROR_MESSAGE("更新数据失败"),

        DB_DELETE_ERROR_CODE("2003"),
        DB_DELETE_ERROR_MESSAGE("删除数据失败"),


        DB_NOTFOUND_ERROR_CODE("2004"),
        DB_NOTFOUND_ERROR_MESSAGE("未查询到相关数据"),


        ACCOUNT_ERROR_CODE("6001"),
        ACCOUNT_ERROR_MESSAGE("账户异常"),


        NO_LOGIN_CODE("9000"),
        NO_LOGIN_MESSAGE("未登录或登录超时"),


        NO_PERMISSION_CODE("9001"),
        NO_PERMISSION_MESSAGE("无此权限"),


        AUTH_FAIL_CODE("9002"),
        AUTH_FAIL_MESSAGE("认证失败"),


        OP_TOO_OFTEN_CODE("9003"),
        OP_TOO_OFTEN_MESSAGE("操作频繁"),


        VC_ERROR_CODE("9004"),
        VC_ERROR_MESSAGE("验证码错误"),


        NOT_FOUND_CODE("9990"),
        NOT_FOUND_MESSAGE("数据不存在"),


        CALL_THIRD_SERV_ERROR_CODE("9991"),
        CALL_THIRD_SERV_ERROR_MESSAGE("调用三方接口错误"),


        VALID_ERROR_CODE("9995"),
        VALID_ERROR_MESSAGE("非法的参数"),


        REQ_ERROR_CODE("9996"),
        REQ_ERROR_MESSAGE("非法的请求"),


        DBERROR_CODE("9997"),
        DBERROR_MESSAGE("数据库操作失败"),


        ILLEGAL_CODE("9998"),
        ILLEGAL_MESSAGE("非法操作"),


        ERROR_CODE("9999"),
        ERROR_MESSAGE("系统错误");

        //#######################4XXX业务验证错误##########################


        private String result;

        Result(String s) {
            this.result=s;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}

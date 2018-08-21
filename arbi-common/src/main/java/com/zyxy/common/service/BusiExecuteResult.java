package com.zyxy.common.service;

import com.zyxy.common.vo.ApiResultVO;

/**
 * 业务执行结果类
 */
public class BusiExecuteResult<K> {

    /**
     * 是否执行成功
     */
    private boolean success;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    K body;

    public static <K> BusiExecuteResult<K> builderSuccessResult() {
        BusiExecuteResult<K> result = builderResult();
        result.success = true;
        return result;
    }
    
    public static <K> BusiExecuteResult<K> builderSuccessResult(K k) {
        BusiExecuteResult<K> result = builderResult();
        result.success = true;
        result.setBody(k);
        return result;
    }

    public static <K> BusiExecuteResult<K> builderErrorResult(ApiResultVO.Coder coder) {
        BusiExecuteResult<K> result = builderResult(coder);
        result.success = false;
        return result;
    }

    public static <K> BusiExecuteResult<K> builderErrorResult(String code, String msg) {
        BusiExecuteResult<K> result = builderResult();
        result.success = false;
        result.code = code;
        result.msg = msg;
        return result;
    }

    private static <K> BusiExecuteResult<K> builderResult(ApiResultVO.Coder coder) {
        BusiExecuteResult<K> result = builderResult();
        result.code = coder.getCode();
        result.msg = coder.getMessage();
        return result;
    }

    private static <T> BusiExecuteResult<T> builderResult() {
        return new BusiExecuteResult<T>();
    }

    public K getBody() {
        return body;
    }

    public void setBody(K body) {
        this.body = body;
    }

    /**
     * 是否存在错误
     * @return 返回是否存在错误
     */
    public boolean hasError() {
        return !success;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

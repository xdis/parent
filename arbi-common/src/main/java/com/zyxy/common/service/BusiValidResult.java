package com.zyxy.common.service;

import com.zyxy.common.vo.ApiResultVO;

/**
 * 业务验证结果类
 */
public class BusiValidResult {

    /**
     * 是否通过验证
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

    public static BusiValidResult builderSuccessResult() {
        BusiValidResult result = builderResult();
        result.success = true;
        return result;
    }

    public static BusiValidResult builderErrorResult(ApiResultVO.Coder coder) {
        BusiValidResult result = builderResult(coder);
        result.success = false;
        return result;
    }

    public static BusiValidResult builderErrorResult(String code, String msg) {
        BusiValidResult result = builderResult();
        result.success = false;
        result.code = code;
        result.msg = msg;
        return result;
    }

    private static BusiValidResult builderResult(ApiResultVO.Coder coder) {
        BusiValidResult result = builderResult();
        result.code = coder.getCode();
        result.msg = coder.getMessage();
        return result;
    }

    private static BusiValidResult builderResult() {
        return new BusiValidResult();
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

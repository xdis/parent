package com.zyxy.auth.config;

import com.zyxy.common.exception.BuzzException;
import com.zyxy.common.vo.ApiResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

public class ApiErrorWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    /**
     * The default WebResponseExceptionTranslator.
     */
    private WebResponseExceptionTranslator defaultTranslator = new DefaultWebResponseExceptionTranslator();

    // Constructor omitted

    @Override
    public ResponseEntity translate(final Exception e) throws Exception {
        // Build your own error object
        String errorCode = e.getMessage();
        if (!e.getClass().isAssignableFrom(BuzzException.class)) {
            errorCode = "账号密码错误";
        }
        ApiResultVO<String> ret = new ApiResultVO<>(ApiResultVO.Coder.CALL_SERV_ERROR.getCode(), errorCode, null);
        ret.setBody(e.getMessage());
        // Use the same status code as the default OAuth2 error
        return new ResponseEntity<ApiResultVO>(ret, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
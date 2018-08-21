package com.zyxy.service.micro.core.api.exception;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
public class ExceptionHandle extends BaseController {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
    public ApiResultVO exceptionGet(Exception e) {
        if (log.isErrorEnabled()) {
            log.error("【Controller-Error】", e);
        }
        //短路异常
        if (e instanceof HystrixRuntimeException) {
            return super.error(ApiResultVO.Coder.SYSTEM_BUSY);
        }
        return super.error(ApiResultVO.Coder.ERROR);
    }

}
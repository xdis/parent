package com.zyxy.common.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.util.IOUtil;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.util.RequestUtil;

/**
 * 自定义输入输出注解切面类
 */
@Component
@Aspect
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 设置只切面WebLog注解
     */
    @Pointcut("@annotation(com.zyxy.common.annotation.WebLog)")
    public void webLogAspect() {
    }

    @Around("webLogAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        // 这里执行保存日志的动作
        Object target = joinPoint.getTarget();
        Class<?> cls = getTargetClass(target);
        Method specificMethod = getSpecificMethod(joinPoint, cls);
        WebLog ma = specificMethod.getAnnotation(WebLog.class);
        //获得切面业务名称
        String busiDesr = ma.value();

        //获取当前用户
        SecurityUserVO sessionUser = getSessionUser();
        String userStr = sessionUser == null ? "~public" : sessionUser.getUserInfoId();

        //获取请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 该日志必不可少
        request.setCharacterEncoding("UTF-8");
        String requestBody = "";
        try {
//            requestBody = IOUtil.readString(request.getInputStream(), request.getContentLength());
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("requestBody exception", e);
            }
        }
        logger.info("用户[{}]开始业务[{}]-参数:{}-requestBody:{}", userStr, busiDesr, RequestUtil.getParamMap(request),requestBody);

        Object ret = joinPoint.proceed();

        logger.info("用户[{}]执行业务[{}]成功-返回:{}", userStr, busiDesr, JSONObject.toJSONString(ret));

        return ret;
    }

    private SecurityUserVO getSessionUser() {
        SecurityUserVO user = null;
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        if (au == null || "anonymousUser".equals(au.getPrincipal())) {
            user = new SecurityUserVO();
            user.setId("2");
            return user;
        }
        return (SecurityUserVO)au.getPrincipal();
    }

    /**
     * 获取目标Class
     *
     * @param target
     * @return
     */
    private Class<?> getTargetClass(Object target) {
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(target);
        if (targetClass == null) {
            targetClass = target.getClass();
        }
        return targetClass;
    }

    /**
     * 获取指定方法
     *
     * @param pjp
     * @param targetClass
     * @return
     */
    private Method getSpecificMethod(ProceedingJoinPoint pjp, Class<?> targetClass) {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
        specificMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);
        return specificMethod;
    }
}
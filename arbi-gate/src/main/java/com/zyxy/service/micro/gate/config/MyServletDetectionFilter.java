package com.zyxy.service.micro.gate.config;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.IS_DISPATCHER_SERVLET_REQUEST_KEY;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.DispatcherServlet;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.HttpServletRequestWrapper;
import com.zyxy.common.util.StringUtil;


public class MyServletDetectionFilter extends ZuulFilter {

    public MyServletDetectionFilter() {
    }

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * Must run before other filters that rely on the difference between 
     * DispatcherServlet and ZuulServlet.
     */
    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true; 
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String contentType = request.getContentType();
        if (StringUtil.isNotEmpty(contentType) && contentType.toLowerCase().contains("multipart")) {
            ctx.set(IS_DISPATCHER_SERVLET_REQUEST_KEY, false);
        } else if (!(request instanceof HttpServletRequestWrapper) 
                && isDispatcherServletRequest(request)) {
            ctx.set(IS_DISPATCHER_SERVLET_REQUEST_KEY, true);
        } else {
            ctx.set(IS_DISPATCHER_SERVLET_REQUEST_KEY, false);
        }

        return null;
    }
    
    private boolean isDispatcherServletRequest(HttpServletRequest request) {
        return request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE) != null;
    }       

}
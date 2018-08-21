package com.zyxy.service.micro.third.config;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.zyxy.common.util.DateUtil;
import com.zyxy.common.util.StringUtil;

public class DateConverter implements Converter<String, Date> {

    /** 
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public Date convert(String source) {
        if (StringUtil.isEmpty(source)){
        	return null;
        }
        source = source.trim();
        return DateUtil.formatDate(source);
    }

}

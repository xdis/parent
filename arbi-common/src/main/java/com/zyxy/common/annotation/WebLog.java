package com.zyxy.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义输入输出注解
 */
@Target(ElementType.METHOD)//定义成在方法上面的注解
@Retention(RetentionPolicy.RUNTIME)//运行时执行
public @interface WebLog {
    /**
     * 模块名称
     */
    String value() default "";
}
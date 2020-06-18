package com.husy.springdemo.web.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * @author husy
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SysLog {
    String value() default "";
}

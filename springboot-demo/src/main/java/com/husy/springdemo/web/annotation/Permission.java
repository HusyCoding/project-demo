package com.husy.springdemo.web.annotation;

import java.lang.annotation.*;

/**
 * 权限控制
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
}

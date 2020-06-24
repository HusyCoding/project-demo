package com.husy.springdemo.web.annotation;

import java.lang.annotation.*;

/**
 * 忽略权限
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreLogin {
}

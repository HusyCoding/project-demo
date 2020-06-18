package com.husy.springdemo.web.aspect;

import com.husy.springdemo.common.tool.UserTool;
import com.husy.springdemo.common.util.HttpServletUtils;
import com.husy.springdemo.common.util.JacksonUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

/**
 * 系统操作日志切面累
 * @author: husy
 * @date: 2020/6/18 23:23
 */
@Aspect
@Component
public class SysLogAspect {
    /**
     * 定义一个切入点，匹配带有@SysLog注解的方法
     */
    @Pointcut("@annotation(com.husy.springdemo.web.annotation.SysLog)")
    private void logPointCut() { }


    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around("logPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        long beginTime = System.currentTimeMillis();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        /*
         数据库日志封装
         */
        //操作人账户
        String operator= Optional.ofNullable(UserTool.getAccount()).orElse("匿名用户").toString();
        //请求方式
        String method = request.getMethod();
        //操作人IP
        String ip = HttpServletUtils.getIpAddress();

        /* 请求URL:全路径 request.getRequestURL().toString();
         * 请求URI:除去host（域名或者ip）部分的路径 request.getRequestURI();
         * 请求上下文路径：request.getContextPath();
         * 请求服务的路径:除去host和工程名部分的路径 request.getServletPath()
         */

        // 请求URI
        String uri = request.getRequestURI();
        //请求时间
        Date accessTime = new Date(beginTime);
        //请求参数:JSON字符串
        String params = JacksonUtils.toJSONString(joinPoint.getArgs());

        //执行目标方法
        Object result = joinPoint.proceed();

        //请求耗时
        long costTime = System.currentTimeMillis() - beginTime;

        // TODO 将日志保存到数据库
    }
}

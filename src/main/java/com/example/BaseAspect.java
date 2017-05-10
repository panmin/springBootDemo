package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by PanMin on 2017/5/10.
 */
@Aspect
@Component
public class BaseAspect {
    private Logger logger = LoggerFactory.getLogger(BaseAspect.class);

    @Pointcut("execution(public * com.example.UserController.*(..))")
    public void log(){
        logger.info("log()");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={},method={},args={}",
                request.getRequestURL().toString(),
                joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName(),
                joinPoint.getArgs()
        );
    }

    @After("log()")
    public void doAfter(){
        logger.info("doAfter()");
    }

    @AfterReturning(returning = "obj",pointcut = "log()")
    public void afterReturn(Object obj){
        logger.info("return={}",obj.toString());
    }
}

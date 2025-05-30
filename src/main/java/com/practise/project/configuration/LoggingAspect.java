package com.practise.project.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
	
	
    @Pointcut("execution(* com.practise.project.serviceimpl.*.*(..))")
    public void serviceMethod() {    	
    }
    
    @Pointcut("execution(* com.practise.project.controller.*.*(..))")
    public void controllerMethod() {    	
    }
	
    
    @Before("serviceMehtod()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before calling service method: " + joinPoint.getSignature());
    }
    
    @After("serviceMehtod()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("After calling service method: " + joinPoint.getSignature());
    }

    @Around("serviceMehtod()")
    public Object logExcutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Execution time of service " + joinPoint.getSignature() + " : " + (endTime - startTime) + "ms");
        return result;
    }
        
    @Before("controllerMethod()")
    public void logBeforeController(JoinPoint joinPoint) {
        log.info("Before calling controller method: " + joinPoint.getSignature());
    }
    
    @After("controllerMethod()")
    public void logAfterController(JoinPoint joinPoint) {
        log.info("After calling controller method: " + joinPoint.getSignature());
    }

    @Around("controllerMethod()")
    public Object logExcutionTimeController(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Execution time of controller " + joinPoint.getSignature() + " : " + (endTime - startTime) + "ms");
        return result;
    }
	
}

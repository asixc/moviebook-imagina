package com.moviebook.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(com.moviebook.service..*)")
    public void packageServicePointCut(){}

    @Before("packageServicePointCut()")
    public void servicePackage(JoinPoint joinPoint){
        log.debug("Before Service [{}]  Method: -> [{}]", joinPoint.getSignature(), joinPoint.getSignature().getName());
    }

    @After("packageServicePointCut()")
    public void serviceAfterPackage(JoinPoint joinPoint){
        log.debug("After Service [{}]  Method: -> [{}]", joinPoint.getSignature(), joinPoint.getSignature().getName());
    }
}

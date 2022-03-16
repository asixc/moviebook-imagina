package com.moviebook.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private final Logger log = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* com.moviebook.controller..*(..))")
    public Object logPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // ejecución del método real

        long stop = System.currentTimeMillis();
        long total = stop - start;
        log.debug("[Controller] {} total execution time {} ms", joinPoint.getSignature().getName(), total);

        return result;
    }
}

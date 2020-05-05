package com.udemy.currencyexchangeservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ApiExecutionTimeLog {
    private final Logger log = LoggerFactory.getLogger(ApiExecutionTimeLog.class);

    @Around("@annotation(ApiTimeLog)")
    public Object calculateTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("<<<<<<<< Logging time Recording >>>>>>>>>>>");
        log.info("Logging method: " + joinPoint.getSignature().getName());
        Long startTime = System.currentTimeMillis();
        Object object = new Object();
        object = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        log.info("Total Execution Time: "+(endTime - startTime));
        return object;
    }
}

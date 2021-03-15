package com.sda.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookServiceAspect {

    private static final Logger log = LoggerFactory.getLogger(BookServiceAspect.class);

    // print method name before each method
    @Before("execution(* com.sda.spring.aop.service.BookService.*(..))")
    public void logBeforeAll(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("aspect.logBeforeAll() : {}", methodName);
    }

    @After("execution(* com.sda.spring.aop.service.BookService.*(..))")
    public void logAfterAll(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("aspect.logAfterAll() : {}", methodName);
    }

    @AfterReturning(value = "execution(* com.sda.spring.aop.service.BookService.findById(..))", returning = "returnValue")
    public void logAfterReturn(JoinPoint joinPoint, Object returnValue) {
        String methodName = joinPoint.getSignature().getName();
        log.info("aspect.logAfterReturn() : {} returned: {}", methodName, returnValue);
    }

    @AfterThrowing(value = "execution(* com.sda.spring.aop.service.BookService.exists(..))")
    public void logAfterThrow(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("aspect.logAfterThrow() : {}", methodName);
    }

    @Around("execution(* com.sda.spring.aop.service.BookService.delete(..))")
    public void logAroundDelete(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // everything till proceed is called before join point
        log.info("aspect.logAround() before proceed(): {}", startTime);

        Object returnValue = joinPoint.proceed();   // get the return value

        // everything is executed after (including throwable)
        long totalTime = System.currentTimeMillis() - startTime;

        String methodName = joinPoint.getSignature().getName();
        log.info("aspect.logAround() after proceed(): {} took {} ms", methodName, totalTime);
    }
}

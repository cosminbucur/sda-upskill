package com.sda.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {
    }

//    @Before("executeLogging()")
//    public void logMethodCall(JoinPoint joinPoint) {
//        // get details about the call itself
//
//        StringBuilder message = new StringBuilder("method: ");
//
//        String methodName = joinPoint.getSignature().getName();
//        message.append(methodName);
//
//        Object[] args = joinPoint.getArgs();
//
//        if (args != null && args.length > 0) {
//            message.append(" args=[ |" );
//            Arrays.asList(args).forEach(arg ->
//                    message.append(arg).append(" | ")
//            );
//            message.append("}");
//        }
//        log.info(message.toString());
//    }

//    @AfterReturning(value = "executeLogging()", returning = "returnValue")
//    public void logMethodCall(JoinPoint joinPoint, Object returnValue) {
//        StringBuilder message = new StringBuilder("method: ");
//
//        String methodName = joinPoint.getSignature().getName();
//        message.append(methodName);
//
//        Object[] args = joinPoint.getArgs();
//
//        if (args != null && args.length > 0) {
//            message.append(" args=[ |" );
//            Arrays.asList(args).forEach(arg ->
//                    message.append(arg)
//                            .append(" | ")
//            );
//            message.append("}");
//        }
//
//        if (returnValue instanceof Collection) {
//            int size = ((Collection<?>) returnValue).size();
//            message
//                    .append(", returned: ").append(size)
//                    .append(" instance(s)");
//        } else {
//            message
//                    .append(", returned: ")
//                    .append(returnValue.toString());
//        }
//
//        log.info(message.toString());
//    }

    @Around(value = "executeLogging()")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // everything till proceed is called before join point
        Object returnValue = joinPoint.proceed();   // get the return value
        // everything is executed after (including throwable)
        long totalTime = System.currentTimeMillis() - startTime;

        StringBuilder message = new StringBuilder("method: ");

        String methodName = joinPoint.getSignature().getName();
        message.append(methodName);

        message.append(" totalTime: ")
                .append(totalTime)
                .append(" ms");

        Object[] args = joinPoint.getArgs();

        if (args != null && args.length > 0) {
            message.append(" args=[ |");
            Arrays.asList(args).forEach(arg ->
                    message.append(arg)
                            .append(" | ")
            );
            message.append("}");
        }

        if (returnValue instanceof Collection) {
            int size = ((Collection<?>) returnValue).size();
            message
                    .append(", returned: ").append(size)
                    .append(" instance(s)");
        } else {
            message
                    .append(", returned: ")
                    .append(returnValue.toString());
        }

        log.info(message.toString());
        return returnValue;
    }
}

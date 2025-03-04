package com.book.bookApp.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private long start, end;
    // Log before any method in service classes
    @Before("execution(* com.book.bookApp.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        start = System.currentTimeMillis();
        logger.info("Entering method: {}", joinPoint.getSignature().toShortString()+" @ "+start);
    }

    // Log after a method returns successfully
    @AfterReturning(pointcut = "execution(* com.example.myapp.service.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        end = System.currentTimeMillis();
        logger.info("Method {} returned: {}", joinPoint.getSignature().toShortString(), result + " @ "+end);
        logger.info("Method {} took {} ms to execute.", joinPoint.getSignature().toShortString(), (end - start));
    }

    // Log if a method throws an exception
    @AfterThrowing(pointcut = "execution(* com.example.myapp.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        logger.error("Method {} threw exception: {}", joinPoint.getSignature().toShortString(), ex.getMessage());
    }
}


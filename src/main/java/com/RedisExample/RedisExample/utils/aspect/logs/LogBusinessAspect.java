package com.RedisExample.RedisExample.utils.aspect.logs;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
@Slf4j
public class LogBusinessAspect {

    @Around("@annotation(LoggingAspect)")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getMethod().getName();
        Instant startTime = Instant.now();
        Object result = joinPoint.proceed();
        String additionalMessage = methodSignature.getMethod().getAnnotation(LoggingAspect.class).additionalMessage();
        long elapsedTime = Duration.between(startTime, Instant.now()).toMillis();
        log.info("Class Name: {}, Method Name: {}, Additional Message: {}, Elapsed Time: {}ms",
                className, methodName, additionalMessage, elapsedTime);
      //  log.info("Result: {}", result); listelerde uzun ve mantiksiz ama dönüş tipini veriyor
        return result;
    }
}
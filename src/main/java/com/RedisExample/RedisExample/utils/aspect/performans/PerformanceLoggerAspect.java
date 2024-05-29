package com.RedisExample.RedisExample.utils.aspect.performans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceLoggerAspect {

    //@Around("@annotation(com.RedisExample.RedisExample.utils.aspect.performance.PerformanceAspect)")  calısmadı duz yazdım oldu....
    @Around("@annotation(PerformanceAspect)")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Metot öncesi: " + pjp.getSignature());
        Object output = pjp.proceed();
        System.out.println("Metot sonrasi");
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Metot kosturma zamani: "
                + elapsedTime + " milliseconds.");
        return output;
    }

}
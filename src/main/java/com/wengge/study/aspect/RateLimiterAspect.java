package com.wengge.study.aspect;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.Aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 此切面专门用于请求的限流
 */
@Component
@Aspect
public class RateLimiterAspect extends Aspects {

    private static Map<String, RateLimiter> rateLimiterMap = new HashMap<>();

    @Before("execution(* com.wengge.study.controller.*.*(..))")
    public void doRateLimiter(JoinPoint joinPoint) {
        Object Object = joinPoint.getTarget();
        String className = Object.getClass().getName();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String methodName = method.getName();
        String key = String.format("%s.%s", className, methodName);
        RateLimiter rateLimiter = rateLimiterMap.get(key);
        if (rateLimiter == null) {
            synchronized (this) {
                if (rateLimiter == null) {
                    rateLimiter = RateLimiter.create(2);
                    rateLimiterMap.put(key, rateLimiter);
                }
            }
        }
        if (rateLimiter.tryAcquire()) {
            joinPoint.getClass();
        } else {
            throw new RuntimeException("超过最大访问次数，请稍后再试");
        }
    }
}

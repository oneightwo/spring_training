package com.helloworld.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.helloworld.service.*.*(..))")
    public void beforeServiceMethodInvocation(JoinPoint joinPoint) {
        System.out.println("Invocation of method " + joinPoint.getSignature());
    }

    @Around("execution(* com.helloworld.service.*.*(..))")
    public Object aroundServiceMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution of method " + joinPoint.getSignature() + " took " + (end - start) + "msec.");
        return res;
    }
}

package com.helloworld.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LogAspect {

    public void beforeServiceMethodInvocation(JoinPoint joinPoint) {
        System.out.println("Invocation of method " + joinPoint.getSignature());
    }

    public Object aroundServiceMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution of method " + joinPoint.getSignature() + " took " + (end - start) + "msec.");
        return res;
    }
}

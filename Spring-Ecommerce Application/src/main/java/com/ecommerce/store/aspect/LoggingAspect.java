package com.ecommerce.store.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static Logger myLogger=Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* com.ecommerce.store.service.*.*(..)))")
    public void serviceLogging(JoinPoint joinPoint)
    {
        String method=joinPoint.getSignature().toString();
        myLogger.info("--> executing @Before  on method: "+method);
    }

    @AfterThrowing(pointcut = "execution(* com.ecommerce.service.*.*(..))",
            throwing="exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable exc)
    {
        String method=joinPoint.getSignature().toString();
        myLogger.info("--> executing @AfterThrowing on method: "+method);

        myLogger.info("-->The Exception is : "+exc);

    }
}

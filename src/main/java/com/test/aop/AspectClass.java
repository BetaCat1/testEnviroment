package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class AspectClass {


    private static final String METHOD_EXECUTION =
            "execution(* com.test.service.AopService.show(..))";
    private static final String ANNOTATION =
            "@annotation(com.test.annotation.MyAnnotation)";

    @Pointcut(ANNOTATION)
    public void methodCutting() {
    }

    @Before("methodCutting()")
    public void beforMethodExecution() {
        System.out.println( "before method execution");
    }

    @After("methodCutting()")
    public void afterMethodExecution() {
        System.out.println("after method execution");
    }

    @AfterReturning(value = "methodCutting()",returning = "name")
    public void afterReturningMethodExecution(String name) {
        System.out.println("afterReturning method execution"+name);
    }

    @Around("methodCutting()")
    public void AroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕开始");
        joinPoint.proceed();
        System.out.println("环绕结束");
    }
}
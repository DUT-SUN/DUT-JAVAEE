package com.example.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/29  14:06
 */
@Aspect//告诉框架我是个切面类
@Component//随着框架启动而启动
public class UserAspect {
    //定义切点
    @Pointcut("execution(* com.example.springaop.Controller.UserController.*(..) )")
    public void Pointcut(){}

    /**
     * 后置通知
     */
    @After("Pointcut()")
    public void AfterAdvice(){
        System.out.println("执行了后置通知");
    }

    /**
     * 前置通知
     */
    @Before("Pointcut()")
    public void beforeAdvice(){
        System.out.println("执行了前置通知");
    }
    /**
    * @explain 环绕通知
    * @param
    * @return java.lang.Object
    * @author DUT-SUN
    * @date   2023/3/29
    */
    @Around("Pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("进入环绕通知了");
        Object object=null;
        object=joinPoint.proceed();
        System.out.println("退出环绕通知了");
        return object;
    }
}

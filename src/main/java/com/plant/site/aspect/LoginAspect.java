//package com.plant.site.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpSession;
//import java.util.Objects;
//
///**
// * @description: TODO
// * @author: yumingbin@zto.cn
// * @date: 2019/1/14 09:18
// * @version:1.0
// **/
//
//@Aspect
//@Component//构成
//@Slf4j
//public class LoginAspect {
//
//
//    /*
//     * around
//     * @
//     */
//    //@Around是在函数运行的之前和之后，能决定是否运行函数
//    @Around("@annotation(NeedManagerPower)")
//    public void checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("@Around ->Before 方法执行前");
//        joinPoint.proceed();
//        log.info("@Around ->After 方法执行前,login方法之后");
//        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
//
//        if (null != session.getAttribute("userName")) {
//            log.info("login Success");
//        } else {
//            log.info("login Failed");
//        }
//    }
//
//    //* 表示所有的返回值
//    @Pointcut("execution(public  * com.plant.site.controller.SysUserController.login(..))")
//    public void login() {//切点映射，命名不规定
//        log.info("login aspect ");
//    }
//
//    @Before("login()")
//    public void loginBefore() {
//
//        log.info("login  Before ");
//    }
//
//    @After("login()")
//    public void loginAfter() {
//        log.info("login  After ");
//
//    }
//}

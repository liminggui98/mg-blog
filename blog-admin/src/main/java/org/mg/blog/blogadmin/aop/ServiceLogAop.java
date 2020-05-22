package org.mg.blog.blogadmin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 记录方法调用记录，并写入系统日志表
 */
@Aspect
public class ServiceLogAop {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLogAop.class);

    @Pointcut(value = "execution(* org.mg.blog.blogadmin.service.*.*(..))")
    public void logPointCount() {
    }

    @Before(value = "logPointCount()")
    public void before(JoinPoint point) {
        LOGGER.warn("invoke method :{}", point.getSignature());
    }
}

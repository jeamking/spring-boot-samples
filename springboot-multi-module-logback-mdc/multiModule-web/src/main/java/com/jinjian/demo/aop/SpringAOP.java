package com.jinjian.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
 
import java.util.Arrays;
import java.util.UUID;
 
/**
 * @description: 配置切面,配置日志 和请求参数打印
 */
@Aspect
//@Order(-99) // 控制多个Aspect的执行顺序，越小越先执行,为了要在Spring的事务之后执行,所以给他设置99
@Configuration
public class SpringAOP {
 
    private static final Logger logger = LoggerFactory.getLogger(SpringAOP.class);
 
    /**
     * 定义切点Pointcut
     * 第一个*号：表示返回类型， *号表示所有的类型
     * 第二个*号：表示类名，*号表示所有的类
     * 第三个*号：表示方法名，*号表示所有的方法
     * 后面括弧里面表示方法的参数，两个句点表示任何参数
     */
    @Pointcut("execution(* com.jinjian.demo.web.controller..*.*(..))")
    public void executionService() {
 
    }
 
 
    /**
     * 方法调用之前调用
     * @param joinPoint
     */
    @Before(value = "executionService()")
    public void doBefore(JoinPoint joinPoint){
 
        //添加日志打印
        String requestId = String.valueOf(UUID.randomUUID());
        MDC.put("requestId",requestId);
        logger.info("=====>@Before：请求参数为：{}",Arrays.toString(joinPoint.getArgs()));
 
    }
 
    /**
     * 方法之后调用
     * @param joinPoint
     * @param returnValue 方法返回值
     */
    @AfterReturning(pointcut = "executionService()",returning="returnValue")
    public void  doAfterReturning(JoinPoint joinPoint,Object returnValue){
 
        logger.info("=====>@AfterReturning：响应参数为：{}",returnValue);
        // 处理完请求，返回内容
        MDC.clear();
    }
 
    /**
     * 统计方法执行耗时Around环绕通知
     * @param joinPoint
     * @return
     */
    @Around("executionService()")
    public Object timeAround(ProceedingJoinPoint joinPoint) {
 
        //获取开始执行的时间
        long startTime = System.currentTimeMillis();
 
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        //Object[] args = joinPoint.getArgs();
 
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            logger.error("=====>统计某方法执行耗时环绕通知出错", e);
        }
 
        // 获取执行结束的时间
        long endTime = System.currentTimeMillis();
        //MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        // 打印耗时的信息
        logger.info("=====>处理本次请求共耗时：{} ms",endTime-startTime);
        return obj;
    }
 
 
}
package com.lte.mysynctask.firtask.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * @Auther: laite
 * @Date: 2022/1/15 - 01 - 15 - 21:49
 * @Description: com.lte.mysynctask.firtask.aop
 * @version: 1.0
 */
@Component
@Aspect
public class ParamAuthAOP {
    //切点表达式
    @Pointcut("@annotation(com.lte.mysynctask.firtask.aop.ParamAuthAnnotation)")
    private void pointCheck() {
    }

    @Around("pointCheck()")
    public Object checkAround(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        //获取入参
        Object[] args = thisJoinPoint.getArgs();
        //获取方法签名
        MethodSignature signature = (MethodSignature) thisJoinPoint.getSignature();
        //获取方法
        Method method = signature.getMethod();
        //获取方法注解
        ParamAuthAnnotation annotation = method.getAnnotation(ParamAuthAnnotation.class);
        //获取自定义注解
        String type = annotation.value();
        //对注解信息类型进行判断
        if (ParamAuthAnnotation.TYPE_INNER.equals(type)) {
            if (checkAroundInner(args)) {
                //执行目标方法
                return thisJoinPoint.proceed(args);
            }
            return "入参不能为空";
        }
        if (checkAroundOut(args)) {
            return thisJoinPoint.proceed(args);
        }
        return "入参不能为1";
    }


    private Boolean checkAroundInner(Object[] args) {

        StringBuffer buffer = new StringBuffer();
        for (Object arg : args) {
            buffer.append(arg);
        }
        String string = buffer.toString();
        if (string.contains("1")) {
            return false;
        }
        return true;
    }

    private Boolean checkAroundOut(Object[] args) {
        StringBuffer buffer = new StringBuffer();
        for (Object arg : args) {
            buffer.append(arg);
        }
        String string = buffer.toString();
        if (string.isEmpty()) {
            return false;
        }
        return true;
    }

}

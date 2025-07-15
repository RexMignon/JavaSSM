package com.mignon.spring.aop;


import com.mignon.spring.common.Result;
import com.mignon.spring.utils.BindResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * @author WWenHai
 * @desc: 切面对象
 * @date: 2025-07-09 13:57
 **/

@Slf4j
@Component
@Aspect
public class MyAspect {

    @Pointcut("@within(com.mignon.spring.annotation.Logger)||@annotation(com.mignon.spring.annotation.Logger)")
    public void pointcutAround() {

    }




    @Around(value = "pointcutAround()", argNames = "pjp")
    public Object logBeforeAnyTargetMethod(ProceedingJoinPoint pjp) throws Throwable {
         long start = System.currentTimeMillis();
        Object result = null;
        String methodName = "\n\n\n============+>"+pjp.getSignature().getName()+"<+==============\n\n\n";
        System.out.println(methodName);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < methodName.length()-6; i++) {
            sb.append("=");
        }
        try {
            result = pjp.proceed();
        } catch (Exception e) {
            System.out.println("方法执行异常: " + e.getMessage());
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(pjp.getSignature().getName() + " 方法执行时间: " + (end - start) + "ms");
        }


        System.out.println("\n\n\n"+sb+"\n\n\n");
        return result;
    }

     @Pointcut("@within(com.mignon.spring.annotation.CheckParams)&&args(.., bindingResult)||@annotation(com.mignon.spring.annotation.CheckParams)&& args(.., bindingResult)")
    public void checkParams(BindingResult bindingResult) {

    }



    /**
     * AOP +  Validator 参数校验机制
     *
     * */
     @Around(value = "checkParams(bindingResult)", argNames = "joinPoint,bindingResult")
    public Object handleValidation(ProceedingJoinPoint joinPoint, BindingResult bindingResult)
             throws Throwable {
        String errorMessage = BindResultUtil.getValidationErrors(bindingResult);
        if (Objects.nonNull(errorMessage)) {
            return Result.failed("参数校验失败: " + errorMessage);
        }
        return joinPoint.proceed();
    }


}

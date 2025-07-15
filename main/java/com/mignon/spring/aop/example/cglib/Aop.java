package com.mignon.spring.aop.example.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author WWenHai
 * @desc: 面向切面编程
 * @date: 2025-07-09 09:56
 **/
public class Aop {


    public static void main(String[] args) {

        //目标对象
        Target target = new Target();

        //增强对象
        TagetAdvice advice = new TagetAdvice();


        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置父类 (目标)
        enhancer.setSuperclass(target.getClass());
        // 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                // 执行前置
                advice.before();
                //执行目标
                Object invoke = method.invoke(target, objects);
                // 执行后置
                advice.afterReturning();
                return invoke;
            }
        });
        //创建代理对象
        Target target1 = (Target) enhancer.create();
        target1.save();
    }
}

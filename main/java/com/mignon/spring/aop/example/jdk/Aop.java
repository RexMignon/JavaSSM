package com.mignon.spring.aop.example.jdk;


import com.mignon.spring.aop.example.jdk.Impl.TargetImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WWenHai
 * @desc: 面向切面编程
 * @date: 2025-07-09 09:56
 **/
public class Aop {


    public static void main(String[] args) {

        //目标对象
        TargetImpl target = new TargetImpl();

        //增强对象
        TagetAdvice advice = new TagetAdvice();

        TargetInterFace targetInterFace = (TargetInterFace) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标对象类加载器
                target.getClass().getInterfaces(),//目标对象 相同的接口字节码对象数组
                new InvocationHandler() {
                    //调用代理对象的任何方法,实质执行的都是inoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 前置增强
                        advice.before();
                        Object invoke = method.invoke(target, args);
                        //后置增强
                        advice.afterReturning();
                        return invoke;
                    }
                }
        );

        targetInterFace.save();
    }
}

package com.mignon.spring.aop.example.cglib;


/**
 * @author WWenHai
 * @desc: 增强组件
 * @date: 2025-07-09 10:03
 **/
public class TagetAdvice {

    public void before() {
        System.out.println("前置增强....");
    }

    public void afterReturning() {
        System.out.println("后置增强...");
    }






}

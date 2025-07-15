package com.mignon.spring.aop.example.jdk.Impl;


import com.mignon.spring.aop.example.jdk.TargetInterFace;

/**
 * @author WWenHai
 * @desc: 实现
 * @date: 2025-07-09 10:01
 **/
public class TargetImpl implements TargetInterFace {

    @Override
    public void save() {
        System.out.println("save...");
    }

}

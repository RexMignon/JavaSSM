package com.mignon.spring.aop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author WWenHai
 * @desc: 实现目标对象
 * @date: 2025-07-09 10:01
 **/
@Component(value = "target")
public class TargetImpl implements TargetInterFace {

    @Override
    public void save() {
        System.out.println("save...");
    }


    public static void main(String[] args) {
    ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        TargetInterFace tar  = (TargetInterFace) app.getBean("target");
        tar.save();
    }
}

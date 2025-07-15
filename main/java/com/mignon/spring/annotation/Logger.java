package com.mignon.spring.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author WWenHai
 * @desc: 日志注解
 * @date: 2025-07-09 16:38
 **/
@Target({
        ElementType.METHOD,
        ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Logger{
    String value() default "a Logger";
}
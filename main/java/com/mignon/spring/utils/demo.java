package com.mignon.spring.utils;


import org.springframework.beans.factory.BeanFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-07 13:35
 **/
public class demo {


    BeanFactory beanFactory;

    public void getString(String... a) {
        if (Objects.nonNull(a)) {
            System.out.println(
                    Arrays.toString(a)
            );
        }
    }


    public static void main(String[] args) {

    }
}

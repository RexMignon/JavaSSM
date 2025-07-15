package com.mignon.spring.converter;


import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JinQian Su
 * @desc: 日期转换器
 * @date: 2025-07-06 18:21
 **/
//把什么转成什么 泛型

public class DateConverter implements Converter<String, Date> {


    @Value("${date.format}")
    private String simpleDateFormatConfig;

    /**
     * 将日期字符串转换为日期对象
     */
    @Override
    public Date convert(@NonNull String s) {
        System.out.println(this.simpleDateFormatConfig);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.simpleDateFormatConfig);
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return date;
    }
}

package com.mignon.spring.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-12 16:46
 **/
@Data
@EqualsAndHashCode
@ToString
public class Order
{


    private Integer id;

    private User user;
}

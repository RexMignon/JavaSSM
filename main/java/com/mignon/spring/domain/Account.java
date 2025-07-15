package com.mignon.spring.domain;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author WWenHai
 * @desc: 转账业务
 * @date: 2025-07-09 23:16
 **/
@Data
@ToString
@EqualsAndHashCode
public class Account {
    private String name;
    private double money;
}

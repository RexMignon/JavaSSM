package com.mignon.spring.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-10 14:37
 **/

@Data
@ToString
@EqualsAndHashCode
@ApiModel("返回给View的User封装POJO类")
public class UserVO {

    @ApiModelProperty(name = "用户名", notes = "一个简单的用户名")
    private String name;

    @ApiModelProperty(name = "通行令牌", notes = "返回通行令牌,仅作测试...一般setHeader或setCookie")
    private String token;
}

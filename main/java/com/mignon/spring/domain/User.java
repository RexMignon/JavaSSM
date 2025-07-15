package com.mignon.spring.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author WWenHai
 * @desc: User领域模型
 * @date: 2025-07-10 13:59
 **/

@Data
@ToString
@EqualsAndHashCode
@ApiModel(description = "用户模型")
public class User {

    @ApiModelProperty(name = "自增主键id", hidden = true, value = "用户唯一id")
    @Min(value = 0, message = "不得小于0")
    private Integer id;

    @ApiModelProperty(name = "用户名", required = true, notes = "用户的用户名称,用来作为用户登录的唯一标识")
    @NotBlank(message = "用户名不得为空")
    private String name;


    @ApiModelProperty(name = "密码", hidden = true, notes = "通过信息摘要算法哈希过后的字符串, 前端无需提供明文数据")
    @NotBlank(message = "密码不得为空")
    private String password;
}

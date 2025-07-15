package com.mignon.spring.entity.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotBlank;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-10 14:41
 **/

@Data
@ToString
@EqualsAndHashCode
@ApiModel("用于传递User信息的数据类")
@Alias("userDTO")
public class RUserDTO {

    @ApiModelProperty(name= "id")
    private Integer id;

    @ApiModelProperty(name = "用户名")
    @NotBlank(message = "name不能为空")
    private String name;

    @ApiModelProperty(name = "密码", hidden = true)
    @NotBlank(message = "密码不能为空")
    private String password;
}

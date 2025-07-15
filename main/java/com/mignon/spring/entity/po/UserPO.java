package com.mignon.spring.entity.po;


import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@ToString
public class UserPO {
    @NotNull(message = "id不能为空")
    @Positive(message = "id不能为负数")
    private Integer id;

    @NotBlank(message = "名称不能为空")
    private String name;
}

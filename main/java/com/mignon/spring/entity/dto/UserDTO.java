package com.mignon.spring.entity.dto;


import com.mignon.spring.entity.po.UserPO;
import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author: JinQian Su
 * @desc:
 * @date: 2025-07-02 00:37
 **/
@Data
@ToString
public class UserDTO {


    @NotEmpty(message = "userVOList不能为空")
    @Valid
    private List<UserPO> userVOList;

    @NotBlank(message = "名称不能为空")
    private String name;

    @Min(value = 18, message = "年龄需大于等于18岁")
    private Integer age;
}

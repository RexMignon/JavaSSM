package com.mignon.spring.entity.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-08 10:00
 **/
@Data
@EqualsAndHashCode
@ToString
public class FileDTO {


    @NotBlank(message = "名称不能为空")
    private String name;

    @NotBlank(message = "路径不能为空")
    private String path;
}

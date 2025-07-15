package com.mignon.spring.entity.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-09 23:36
 **/
@Data
@ToString
@EqualsAndHashCode
public class AccountDTO {

    @NotBlank(message = "参数不能为空")
   private String outMan;

   @NotBlank(message = "参数不能为空")
   private String inMan;

    @Min(value = 0, message = "不能转负数")
   private Double money;
}

package com.mignon.spring.entity.po;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-10 14:45
 **/

@Data
@ToString
@EqualsAndHashCode
public class RUserPO {

    private Integer id;

    private String name;

    private String password;
}

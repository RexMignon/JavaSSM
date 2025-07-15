package com.mignon.spring.entity.po;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WWenHai
 * @desc: Filedo
 * @date: 2025-07-08 09:40
 **/
@Data
@EqualsAndHashCode
public class FilePO {

    private String fileName;

    private String filePath;

    private Integer fileId;

}

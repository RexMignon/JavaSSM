package com.mignon.spring.dao;


/**
 * @author WWenHai
 * @desc: 测试SpringJDBC模板
 * @date: 2025-07-08 09:29
 **/
public interface FileDao {


    public Integer getFileByFileName(String fileName);

    public Boolean setFile(String fileName, String filePath);
}

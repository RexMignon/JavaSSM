package com.mignon.spring.dao.impl;


import com.mignon.spring.annotation.Logger;
import com.mignon.spring.dao.FileDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-08 09:30
 **/
@Repository
@RequiredArgsConstructor
public class FileDaoImpl implements FileDao {



    private final JdbcTemplate jdbcTemplate;

    /**<br/>
     * 关于 Spring_JDBC Template<br/>
     * ①导入spring_jdbc+spring_tx坐标<br/>
     * ②创建数据库表与实体<br/>
     * ③创建jdbc template对象<br/>
     * ④执行数据库操作<br/>
     * */
    @Override
    @Logger
    public Integer getFileByFileName(String fileName) {
        return 0;
    }

    @Override
    @Logger
    public Boolean setFile(String fileName, String filePath) {
        String sql = "INSERT INTO File (name, path) VALUES (?, ?)";
        return jdbcTemplate.update(sql, fileName, filePath)>0;
    }
}

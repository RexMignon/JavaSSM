package com.mignon.spring.handler;


import com.mignon.spring.domain.User;
import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author WWenHai
 * @desc: 需求如下,我想要存入数据库时存成一个时间戳, 当我转换为java时又转成Date<br/>
 * < typeHandlers><br/>
 *         < typeHandler handler="com.mignon.spring.handler.MybatisTypeHandler"/><br/>
 *     < / typeHandlers><br/>
 *     @ MappedTypes({
 *         Date.class
 * })
 * @ MappedJdbcTypes(JdbcType.BIGINT)
 *     <br/>  sessionFactory.setTypeHandlers(new MybatisTypeHandler());
 *
 *     // 方式 2：指定扫描包（推荐）
 *     sessionFactory.setTypeHandlersPackage("com.mignon.spring.handler");
 *<br/>
 * @date: 2025-07-12 14:56
 *
 * @see  <a href="#">mybatis-config.xml</a>
 **/
@MappedTypes({
        Date.class
})
@MappedJdbcTypes(JdbcType.BIGINT)
public class MybatisTypeHandler extends BaseTypeHandler<Date> {



    /**
     * 为java程序设置数据到数据库的回调方法
     * */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        // 这里的i的意思是index
        preparedStatement.setLong(i, time);
    }



    /**
     * 查询时 mysql的字符串类型转换成java的Type类型的方法
     * */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        // String 参数 是要转换的字段的名称
        // ResultSet 是结果集
        // 获取结果集中我需要的数据 将其转换为Date并返回
        long lo = resultSet.getLong(s);
        Date date = new Date(lo);
        return date;
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long lo = resultSet.getLong(i);
        Date date = new Date(lo);
        return date;
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long lo = callableStatement.getLong(i);
        Date date = new Date(lo);
        return date;
    }
}

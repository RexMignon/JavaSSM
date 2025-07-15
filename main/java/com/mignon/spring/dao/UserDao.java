package com.mignon.spring.dao;


import java.sql.SQLException;

public interface UserDao {
    /**
     * 新增用户方法
     * @param userName 用户名称,账号
     * @param passWord 用户密码
     * @return boolean 返回是否成功
     * */
    boolean AddUser(String userName,String passWord) throws SQLException;
}

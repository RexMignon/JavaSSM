package com.mignon.spring.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.mignon.spring.dao.UserDao;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.SQLException;


//<bean id="userDao" class="com.mignon.spring.dao.impl.UserDaoImpl"/>
@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    @NonNull
    private DataSource dataSource;


    @Override
    public boolean AddUser(String userName, String passWord) throws SQLException {
        System.out.println("UserDao的adduser方法被调用");
        System.out.println(dataSource.getConnection());
        return true;
    }
}

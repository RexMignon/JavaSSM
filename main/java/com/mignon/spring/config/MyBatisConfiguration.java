package com.mignon.spring.config;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.Alias;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * @author WWenHai
 * @desc: Mybatis 初始化工厂方法以及mapper扫描等
 * @date: 2025-07-10 14:19
 **/
@MapperScan(
    basePackages = {
            "com.mignon.spring.mapper",
            "com.mignon.spring.handler"
    },
    sqlSessionFactoryRef = "sqlSessionFactory"
)
public class MyBatisConfiguration {


    @Value("classpath:mybatis-config.xml")
    private Resource mybatisConfigLocation;

    @Value("classpath:mapper/*.xml")
    private Resource[] mybatisMapperLocations;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource,Interceptor pageHelper) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPlugins(pageHelper);
        factoryBean.setConfigLocation(mybatisConfigLocation);
        factoryBean.setMapperLocations(mybatisMapperLocations);
        return factoryBean.getObject();
    }


    @Bean("pageHelper")
    public Interceptor getPageHelper(){
        PageInterceptor  pageInterceptor = new PageInterceptor();
        Properties  properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}

package com.mignon.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**

 *  加载配置文件<br/>
 *  context:property-placeholder location="classpath:jdbc.properties"<br/>
 *  对应<br/>
 *  PropertySource("classpath:jdbc.properties")
 * @author JinQian Su
 * */

@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String uri;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.username}")
    private String userName;

    //Spring将当前方法的返回值存储到Spring容器中
    //数据源
    @Bean("dataSource")
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(uri);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }



    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbc(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


}

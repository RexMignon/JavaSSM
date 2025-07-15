package com.mignon.spring.config;


import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Configuration注解 标志该类为一个Spring 的核心配置类<br/>
 * 组件扫描<br/>
 * context:component-scan base-package="com.mignon.spring"<br/>  对应 <br/> ComponentScan("com.mignon.spring")
 * <br/>引入DataSourceConfiguraton<br/>
 * import resource=""=> <br/>
 * Import(DataSourceConfiguration.class)<br/>
 * excludeFilters = @ComponentScan.Filter(<br/>
 * type = FilterType.ASPECTJ,<br/>
 * pattern = "com.mignon.spring.controller.*"<br/>
 * ))<br/>
 *
 * @author JinQian Su
 */
@Configuration
@ComponentScan(basePackages = "com.mignon.spring",
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASPECTJ,
                        pattern = "com.mignon.spring.controller.*"
                ),
                @ComponentScan.Filter(
                        type = FilterType.ASPECTJ,
                        pattern = "com.mignon.spring.config.*"
                )}
)

@Import({
        DataSourceConfiguration.class,
        OtherConfiguration.class,
        MyBatisConfiguration.class
})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfiguration {


}


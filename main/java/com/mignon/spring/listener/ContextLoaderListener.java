package com.mignon.spring.listener;

import com.mignon.spring.config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(
                SpringConfiguration.class
        );
        //将Spring的应用上下文对象存储到ServletContext的域中
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(
                "app",
                app
        );
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

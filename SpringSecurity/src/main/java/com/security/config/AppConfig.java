package com.security.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.security")
@PropertySource({"classpath:mysql.properties"})
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    // logger for debugging
    private Logger logger = Logger.getLogger(getClass().getName());

    //view resolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //security database connection
    @Bean
    public DataSource securityDataSource(){

        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        logger.info(">>> jdbc.url = "+environment.getProperty("jdbc.url"));
        logger.info(">>> jdbc.url = "+environment.getProperty("jdbc.user"));

        //setting up JDBC connection properties
        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        //set connection pool properties for JDBC connection
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    //helper method to convert string to int
    private int getIntProperty(String propName){

        String propVal = environment.getProperty(propName);
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }
}

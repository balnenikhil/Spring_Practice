package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    //Adding reference to securityDataSource
    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        /* adding users to memory (hardcoding)
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        authenticationManagerBuilder.inMemoryAuthentication().withUser(users.username("nikhil").password("test123").roles("STUDENT"))
                .withUser(users.username("nandan").password("test456").roles("STUDENT","CLASSLEAD"))
                .withUser(users.username("anudeep").password("test789").roles("TEACHER")); */

        authenticationManagerBuilder.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        //.anyRequest().authenticated()
        http.authorizeRequests().
                antMatchers("/").hasAnyRole("STUDENT", "CLASSLEAD", "TEACHER").
                antMatchers("/class/**").hasAnyRole("CLASSLEAD","TEACHER").
                antMatchers("/teachers/**").hasRole("TEACHER").
                and().formLogin().
                loginPage("/customLoginPage").loginProcessingUrl("/authenticateTheUser").
                permitAll().and().logout().permitAll().
                and().exceptionHandling().accessDeniedPage("/accessDeniedPage");
    }
}

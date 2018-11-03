package com.yuan.zhidao.config;

import com.yuan.zhidao.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@EnableGlobalAuthentication
//@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name ="userService" )
    private UserService userService;

    private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests().antMatchers("/hello","/actuator/*").permitAll();
        http.authorizeRequests().mvcMatchers("/hello","/actuator/*").permitAll();
//        http.addFilter(usernamePasswordAuthenticationFilter);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
//
//    @Override
//    public void setAuthenticationConfiguration(AuthenticationConfiguration authenticationConfiguration) {
//        super.setAuthenticationConfiguration(authenticationConfiguration);
//    }
}

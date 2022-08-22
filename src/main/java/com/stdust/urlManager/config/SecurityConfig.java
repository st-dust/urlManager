package com.stdust.urlManager.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        security.httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/js/**", "/css/**").permitAll();
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
//        security
//                //Configure AUTHORIZATION
//
//                .authorizeRequests()
////                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/auth/login", "/error", "/auth/registration").permitAll()
//                .anyRequest().hasAnyRole("USER", "ADMIN")
//                .and()
//
//                //Configure login page
////                .formLogin().loginPage("/auth/login")
////                .loginProcessingUrl("/process_login")
////                .defaultSuccessUrl("/hello", true)
////                .failureUrl("/auth/login?error")
//
//                //Configure logout
////                .and()
//
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/auth/login");
    }
}
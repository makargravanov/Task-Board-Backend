package com.example.taskboardbackend.Config;

import com.example.taskboardbackend.Core.Domain.CustomJWT.JWTValidator;
import com.example.taskboardbackend.Core.JWTFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JWTFilter> jwtFilter() {
        FilterRegistrationBean<JWTFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JWTFilter(new JWTValidator()));
        registrationBean.addUrlPatterns("/secured/*");
        return registrationBean;
    }
}

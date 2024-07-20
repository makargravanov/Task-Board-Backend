package com.example.taskboardbackend.Config;

import com.example.taskboardbackend.Core.Domain.CustomJWT.JWTValidator;
import com.example.taskboardbackend.Core.JWTFilter;
import com.example.taskboardbackend.GlobalData.ConcurrentJWTKeys;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    private final ConcurrentJWTKeys jwtKeys;

    public FilterConfig(ConcurrentJWTKeys jwtKeys) {
        this.jwtKeys = jwtKeys;
    }

    @Bean
    public FilterRegistrationBean<JWTFilter> jwtFilter() {
        FilterRegistrationBean<JWTFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JWTFilter(new JWTValidator(jwtKeys)));
        registrationBean.addUrlPatterns("/secured/*");
        return registrationBean;
    }
}

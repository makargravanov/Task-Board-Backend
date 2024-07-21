package com.example.taskboardbackend.Config;

import com.example.taskboardbackend.GlobalData.ConcurrentJWTKeys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JWTKeyBeanConfig {
    @Value("${jwt.lifetime}")
    private Integer jwtLifetime;

    @Bean(name = "concurrentJWTKeys")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ConcurrentJWTKeys concurrentJWTKeys() {
        return new ConcurrentJWTKeys(jwtLifetime);
    }
}

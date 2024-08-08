package com.example.taskboardbackend.Config;

import com.example.taskboardbackend.GlobalData.RegisterBuffer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterBufferConfig {

    @Bean
    public RegisterBuffer registerBuffer(){
        return new RegisterBuffer();
    }
}

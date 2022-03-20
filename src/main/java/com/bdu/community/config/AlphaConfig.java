package com.bdu.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

//配置类
@Configuration
public class AlphaConfig {
    //222
    @Bean
    public SimpleDateFormat simpleDateFormat1(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}

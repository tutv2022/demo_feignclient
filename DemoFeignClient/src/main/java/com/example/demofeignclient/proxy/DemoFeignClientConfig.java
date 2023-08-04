package com.example.demofeignclient.proxy;

import com.example.demofeignclient.service.SampleService;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class DemoFeignClientConfig {

    @Autowired
    SampleService sampleService;

    @Bean
    RequestInterceptor requestInterceptor() {
        return new DemoRequestInterceptor();
    }
}

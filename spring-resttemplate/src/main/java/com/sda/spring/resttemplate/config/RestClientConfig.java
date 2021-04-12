package com.sda.spring.resttemplate.config;

import com.sda.spring.resttemplate.interceptors.HeaderModifierInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .interceptors(new HeaderModifierInterceptor())
                .build();
    }
}

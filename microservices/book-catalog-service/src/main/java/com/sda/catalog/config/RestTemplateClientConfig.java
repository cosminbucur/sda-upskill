package com.sda.catalog.config;

import com.sda.catalog.interceptors.RestTemplateHeaderModifierInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder()
                .interceptors(new RestTemplateHeaderModifierInterceptor());

        return restTemplateBuilder.build();
    }
}

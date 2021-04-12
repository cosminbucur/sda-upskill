package com.sda.catalog.config;

import com.sda.catalog.interceptors.HeaderModifierInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateClientConfig {

    @Bean
    // do service discovery in a load balanced way
    // the given url is a hit about which server you need to discover
    // rest template makes an API call to service discovery to get the service location
    // make another API call
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder()
                .interceptors(new HeaderModifierInterceptor());

        return restTemplateBuilder.build();
    }
}

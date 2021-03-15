package com.sda.spring.aop.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.sda.spring.aop")
@EnableAspectJAutoProxy
public class AppConfig {

    // https://mkyong.com/spring/spring-is-not-working-in-value/
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

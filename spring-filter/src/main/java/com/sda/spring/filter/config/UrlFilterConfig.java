package com.sda.spring.filter.config;

import com.sda.spring.filter.filters.UrlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlFilterConfig {

    // register the filter
    @Bean
    public FilterRegistrationBean<UrlFilter> filterRegistrationBean() {
        FilterRegistrationBean<UrlFilter> registrationBean = new FilterRegistrationBean<>();
        UrlFilter urlFilter = new UrlFilter();

        registrationBean.setFilter(urlFilter);
        registrationBean.addUrlPatterns("/url-filter/*");
        registrationBean.setOrder(1); // set precedence
        return registrationBean;
    }
}

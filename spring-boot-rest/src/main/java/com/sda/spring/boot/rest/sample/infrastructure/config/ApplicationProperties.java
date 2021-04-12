package com.sda.spring.boot.rest.sample.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

@ConfigurationProperties("application")
@Validated
public class ApplicationProperties {

    //    @NotNull
//    @NotEmpty
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}

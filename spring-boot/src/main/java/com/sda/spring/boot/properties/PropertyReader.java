package com.sda.spring.boot.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

// https://www.journaldev.com/21448/spring-value-annotation#spring-value-8211-default-value
//@Component
@PropertySource("classpath:application.yml")
public class PropertyReader {

    private static final Logger log = LoggerFactory.getLogger(PropertyReader.class);

    // property binding
    // read from file : default value
    @Value("${appOwner:unknown}")
    private String appOwner;

    // read system environment variables when spring evn is populated
    @Value("${java.home}")
    private String javaHome;

    public PropertyReader() {
        log.info("application owned by: " + appOwner);
        log.info("java home: " + javaHome);

    }
}

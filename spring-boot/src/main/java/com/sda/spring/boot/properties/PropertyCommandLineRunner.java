package com.sda.spring.boot.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertyCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(PropertyCommandLineRunner.class);

    @Autowired
    private CustomProperties customProperties;

    @Override
    public void run(String... args) {
        logger.info("custom {}", customProperties);
    }
}

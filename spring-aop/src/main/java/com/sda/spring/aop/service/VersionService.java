package com.sda.spring.aop.service;

import com.sda.spring.aop.aspect.Countable;
import com.sda.spring.aop.aspect.Loggable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VersionService {

    @Value("${app.version}")
    private String version;

    @Countable
    @Loggable
    public String getVersion(String appName) {
        return appName + " version: " + version;
    }
}

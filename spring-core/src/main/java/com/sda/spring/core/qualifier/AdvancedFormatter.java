package com.sda.spring.core.qualifier;

import org.springframework.stereotype.Component;

@Component("advancedFormatter")
public class AdvancedFormatter implements Formatter {

    @Override
    public String format() {
        System.out.println("advanced format");
        return "ok";
    }
}

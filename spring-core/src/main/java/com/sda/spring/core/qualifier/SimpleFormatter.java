package com.sda.spring.core.qualifier;

import org.springframework.stereotype.Component;

@Component("simpleFormatter")
public class SimpleFormatter implements Formatter {

    @Override
    public String format() {
        System.out.println("simple format");
        return "ok";
    }
}

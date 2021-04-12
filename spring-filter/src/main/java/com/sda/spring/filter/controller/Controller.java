package com.sda.spring.filter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    @GetMapping(value = "/step-one", produces = MediaType.TEXT_PLAIN_VALUE)
    public String stepOne(HttpServletResponse response) {
        if (response.getHeader("custom") != null) {
            log.info("has header custom: {}", response.getHeader("custom"));
        }
        return "step one completed";
    }

    @GetMapping(value = "/step-two", produces = MediaType.TEXT_PLAIN_VALUE)
    public String stepTwo(HttpServletResponse response) {
        if (response.getHeader("custom") != null) {
            log.info("has header custom: {}", response.getHeader("custom"));
        }
        return "step two completed";
    }

    @GetMapping(value = "/url-filter", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ulrFilter() {
        return "url filter works";
    }
}

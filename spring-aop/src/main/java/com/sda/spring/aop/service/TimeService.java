package com.sda.spring.aop.service;

import com.sda.spring.aop.aspect.Countable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Countable
    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return TIME_FORMATTER.format(now);
    }

}

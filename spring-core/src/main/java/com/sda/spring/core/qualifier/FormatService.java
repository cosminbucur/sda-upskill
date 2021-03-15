package com.sda.spring.core.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FormatService {

    @Autowired
    @Qualifier("advancedFormatter")
    private Formatter formatter;

    public void run() {
        formatter.format();
    }
}

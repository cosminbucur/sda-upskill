package com.sda.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaDiscoveryServerApplication {

    // needed for java 11
    // javax.xml.bind.jaxb-api
    // com.sun/xml.bind.jaxb-impl
    // org.glassfish.jaxb.jaxb-runtime
    // javax.activation.activation
    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscoveryServerApplication.class, args);
    }

}
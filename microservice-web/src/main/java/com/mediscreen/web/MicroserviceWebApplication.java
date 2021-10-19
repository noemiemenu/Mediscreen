package com.mediscreen.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type Microservice web application.
 */
@SpringBootApplication
@EnableFeignClients
public class MicroserviceWebApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceWebApplication.class, args);
    }

}

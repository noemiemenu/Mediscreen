package com.mediscreen.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type Microservice report application.
 */
@SpringBootApplication
@EnableFeignClients
public class MicroserviceReportApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceReportApplication.class, args);
    }

}

package com.sample.customannotationsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CustomAnnotationSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomAnnotationSampleApplication.class, args);
    }
}

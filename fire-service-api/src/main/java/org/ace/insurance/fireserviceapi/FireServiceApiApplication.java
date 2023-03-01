package org.ace.insurance.fireserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.ace.insurance")
public class FireServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FireServiceApiApplication.class, args);
    }

}

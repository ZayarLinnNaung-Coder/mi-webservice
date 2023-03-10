package org.ace.insurance.fireservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.ace.insurance")
public class FireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FireServiceApplication.class, args);
    }

}

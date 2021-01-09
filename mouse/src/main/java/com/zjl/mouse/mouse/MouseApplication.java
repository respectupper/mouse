package com.zjl.mouse.mouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "classpath:/config/applicationContext.xml" })
@SpringBootApplication
public class MouseApplication {

    public static void main(String[] args) {
        for(String t : args) {
            System.out.println(t);
        }
        SpringApplication.run(MouseApplication.class, args);
    }

}

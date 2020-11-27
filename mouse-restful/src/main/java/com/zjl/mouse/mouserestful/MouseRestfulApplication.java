package com.zjl.mouse.mouserestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "classpath:/config/applicationContext.xml" })
@SpringBootApplication
public class MouseRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MouseRestfulApplication.class, args);
    }

}

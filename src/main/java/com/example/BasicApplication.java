package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BasicApplication {

	public static void main(String[] args) {
                new SpringApplicationBuilder(BasicApplication.class)
                        .properties("spring.config.name=application").run(args);
        }
}

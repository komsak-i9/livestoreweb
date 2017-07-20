package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
            SpringApplication.run(BasicApplication.class, args);
        }
}

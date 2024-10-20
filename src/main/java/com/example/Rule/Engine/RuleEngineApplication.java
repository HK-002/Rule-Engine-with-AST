package com.example.Rule.Engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.example.Rule.Engine.controller",  // used to tell the starting point and to avoid White label error
    "com.example.Rule.Engine.service",     
    "com.example.Rule.Engine.repository",  
    "com.example.Rule.Engine.model"        
})
public class RuleEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuleEngineApplication.class, args);
    }
}

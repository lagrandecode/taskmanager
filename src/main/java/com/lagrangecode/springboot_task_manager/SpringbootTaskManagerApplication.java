package com.lagrangecode.springboot_task_manager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@OpenAPIDefinition(
        info = @Info(
                title = "Task Manager",
                version = "1.0",
                description = "A simple task manager developed in springboot"
        )
)
@SpringBootApplication
public class SpringbootTaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTaskManagerApplication.class, args);
    }

}


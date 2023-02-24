package com.lpy.thread;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lpy.thread.persistence")
@SpringBootApplication
public class ProjectThread20230209Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectThread20230209Application.class, args);
    }

}

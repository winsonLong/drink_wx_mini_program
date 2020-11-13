package com.example.senclub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.servlet.MultipartConfigElement;


@SpringBootApplication
@MapperScan("com.example.mapper")
@ComponentScan(basePackages = {"com.example.*"})
public class SenclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SenclubApplication.class, args);
    }


}

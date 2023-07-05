package com.sx.sports;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sx.sports.mapper")
public class SportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsApplication.class, args);
    }

}

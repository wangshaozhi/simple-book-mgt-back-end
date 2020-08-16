package com.cqupt.bookserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cqupt.bookserver.Dao")
public class BookserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookserverApplication.class, args);
    }

}

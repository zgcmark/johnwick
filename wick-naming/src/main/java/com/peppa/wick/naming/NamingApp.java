package com.peppa.wick.naming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.peppa.wick.naming.nodes.sql.mapper")
public class NamingApp {

    public static void main(String[] args) {
        SpringApplication.run(NamingApp.class, args);
    }

}

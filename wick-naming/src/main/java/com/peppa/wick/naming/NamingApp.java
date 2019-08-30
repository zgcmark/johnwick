package com.peppa.wick.naming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.peppa.wick.naming.nodes.theme.sql.mapper")
public class NamingApp {

    public static void main(String[] args) {
        SpringApplication.run(NamingApp.class, args);
    }

}

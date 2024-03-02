package com.wxm.springbootbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.wxm.springbootbook.mapper")
@ServletComponentScan(basePackages = "com.wxm.springbootbook.filter")
public class SpringBootBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBookApplication.class, args);
    }

}

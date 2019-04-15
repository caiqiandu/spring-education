package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.jk.mapper")
public class SpringProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProviderApplication.class, args);
    }

}

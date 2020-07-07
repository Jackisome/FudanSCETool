package com.fudanscetool.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fudanscetool.springboot.dao")
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) { SpringApplication.run(SpringbootApplication.class, args); }

}

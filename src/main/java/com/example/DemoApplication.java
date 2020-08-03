package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.mapper")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        SpringApplication.run(DemoApplication.class, args);


        /**
         *  ClassStruct 类型
         *  ClassStruct.class 类型对象
         *
         *  git test 111
         *  issue 01
         *
         */

    }

}

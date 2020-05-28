package com.example;

import jvm.ClassStruct;
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

        /*Class cs0 = Class.forName("jvm.ClassStruct");
        System.out.println("1: " + cs0.getClass().getName());
        System.out.println("2: " + cs0);


        Class cs = ClassStruct.class;
        System.out.println("1: " + cs.getClass().getName());
        System.out.println("2: " + cs);

        Object o = new Object();
        System.out.println("3: " + o);

        Class la = Object.class;
        Class ll = Class.class;
        Object ob = Class.class;


        String str = new String("test-string");
        Class klass = str.getClass();
        System.out.println(klass.getClass().getName()); //  ==> java.lang.Class
        System.out.println(klass);                      // ==> class java.lang.String

        Class klass2 = String.class;
        System.out.println(klass2.getClass().getName()); // ==> java.lang.Class
        System.out.println(klass2);                      // ==> class java.lang.String*/

    }

}

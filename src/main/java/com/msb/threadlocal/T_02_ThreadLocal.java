package com.msb.threadlocal;

import java.util.concurrent.TimeUnit;

public class T_02_ThreadLocal {

    // volatile static Person p = new Person();

    // 与 test_01 的区别在于，前者使用 volatile，当前使用 ThreadLocal
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 2 秒后从 tl 拿，拿不到
            System.out.println(tl.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 1 秒后设置到 tl
            tl.set(new Person());
        }).start();
    }

}

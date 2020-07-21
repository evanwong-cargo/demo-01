package com.msb.tryvolatile;

import java.util.concurrent.TimeUnit;

public class T_01_HelloVolatile {

    volatile
    boolean running = true; // 对比一下有无volatile的情况下，整个程序运行结果的区别

    void method() {
        System.out.println( Thread.currentThread().getName() + " m start");
        while (running) {
        }
        System.out.println( Thread.currentThread().getName() + " m end");
    }

    public static void main(String[] args) {

        T_01_HelloVolatile hv = new T_01_HelloVolatile();


    /*
        方法引用分为三种，方法引用通过一对双冒号:: 来表示，方法引用是一种函数式接口的另一种书写方式
        静态方法引用，通过类名::静态方法名， 如 Integer::parseInt
        实例方法引用，通过实例对象::实例方法，如 str::substring
        构造方法引用，通过类名::new， 如 User::new
     */

        new Thread(hv::method, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
            当 running 有 volatile 修饰时
            - 此变量表示所有线程可见
            - 数值变化会立刻被其他引用此参数的方法感知，Main 方法所在主线程改变 volatile 变量，被 t1 线程感知

            当 running 无 volatile 修饰时
            - 数值变化仅影响本线程相关的 CPU 缓存
         */
        System.out.println( Thread.currentThread().getName() + " before : " + hv.running);
        hv.running = false;
        System.out.println( Thread.currentThread().getName() + " after : " + hv.running);
    }

}

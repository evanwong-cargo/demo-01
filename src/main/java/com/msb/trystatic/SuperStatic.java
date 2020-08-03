package com.msb.trystatic;

public class SuperStatic {

    {
        System.out.println("what is this super ???");
    }

    static {
        System.out.println("initial super");
    }

    static void m1(){
        System.out.println("SuperStatic");
    }

    public  SuperStatic(){
        System.out.println("no args constructor");
    }

    public SuperStatic(String  str) {
        System.out.println("udf string : " + str);
    }

    public void t1(){

    }



}

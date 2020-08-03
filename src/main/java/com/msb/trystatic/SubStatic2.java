package com.msb.trystatic;


public class SubStatic2 extends SuperStatic {

    /*-------------------------------------------------------
        static 静态块
    -------------------------------------------------------*/
    static {
        // int a = value; // illegal forward reference

        value = 456; //
    }

    private static int value = 123;

}

package com.msb.trystatic;

/**
 * 关于 static
 *
 * 1. 唯一
 *      随着 Class 的加载而被加载到方法区，有且仅属于本 Class，有且仅有一份
 * 2. 已知
 *      因为随 Class 的加载而被加载，所以 static 字段或方法优先于对象存在
 * 3. 共享
 *      被 static 修饰的字段或方法，都放在方法区，此区域被线程共享访问
 *
 */
public class SubStatic extends SuperStatic {

    private static volatile String a;  // SubStatic.a

    private static final String b = "bbb"; // ldc from CONSTANT_POOL

    private int c;

    /* 模拟默认隐式无参构造函数
    public SubStatic() {
        super();

        { ... } execute code block, no matter where is it
    }
    */

    public SubStatic() {
        super("111");

        // { ... }   // 执行 nostatic block

        a = "a-1";
        a = "a-2";
    }

    public SubStatic(String str) {
        // super();
        // { ... }

        a = str;
        String str2 = str + 1;

        try {
            Class.forName("aaa");



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hehe1() {
        int a;
        this.getClass().getClassLoader();

        int b = c;

        System.out.println("hehe");
    }

    public void hehe2(String s1) {
        System.out.println("hehe : " + s1);
    }

    /*-------------------------------------------------------
        no-static block 非静态块

        无论显、隐式无参构造方法，还是其他重载构造方法，都必须执行 2 条指令：
        1. 加载 this 引用
        2. 调用 super 父类构造方法

        nostatic-block 中的代码紧跟在 super 方法调用之后执行，且无论放在当前 class 的什么位置
        效果类似于 Spring AOP 的 doAfter 后置处理器
        可以对所有构造方法扩展

        <clinit> 是编译器自动收集的类变量的赋值操作和静态语句块中语句合并产生的
        如果没有赋值操作和静态语句编译器也可以不生成 <clinit>
        所以 <clinit> 是非必须的
    -------------------------------------------------------*/

    {
        a = "a-3";
    }



    static {
        // 字符串拼接，会自动 new StringBuffer 并通过 append 来实现
        System.out.println("initial sub" + a + b);


        /*-------------------------------------------------------
            1. 定义在 static {} 之前的变量，可以访问，可以赋值
            2. 定义在 static {} 之后的变量，不能访问，只能赋值
        -------------------------------------------------------*/
        // int a = value; // illegal forward reference
        value = 456;
    }

    private static int value;


    /**
     * 子类会继承父类的 static 方法
     * 允许存在与父类同名、同参数列表的 static 方法，但这并非重写覆盖
     *
     * 如果执行调用： SubStatic.m1()
     * 当 SubStatic 类中存在 static m1() 时，则执行 SubStatic 中的 m1 方法
     * 当 SubStatic 类中不存在 m1 时，则执行从父类继承的 static m1() 方法
     */
    static void m1(){
        System.out.println("SubStatic");
        String s = "hehe";
    }

    /**
     * 注意和 static 方法 m1 比较
     * no-static 方法 t1 会自动标记为 overried
     */
    public void t1(){
        int a = 1;
        System.out.println(a);
    }

}

package jvm;

public class TestMain {

    public static void main(String[] args) throws ClassNotFoundException {

        Class class1 = Object.class;
        Class class2 = Class.class;
        Object obj = Class.class;

        /**
         * class1 , class2 都是类型对象，所有类型对象的类型都是 Class
         *
         * class1.getClass() 返回类型对象的类型 ==> Class  然后 getName() ==> 返回
         */
        System.out.println(class1.getClass().getName());
        System.out.println(class1.getName());

        System.out.println(class2.getClass().getName());
        System.out.println(class2.getName());

        System.out.println(obj);

    }
}

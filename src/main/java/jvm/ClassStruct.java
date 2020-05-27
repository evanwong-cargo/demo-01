package jvm;

import java.io.Serializable;

/** 1.类信息 */
public final class ClassStruct extends Object implements Serializable {

    /** 2.对象字段信息 */
    private String name;
    private int id;

    /** 4.常量池 */
    public final int CONST_INT = 0;
    public final String CONST_STRING="CONST_STRING";

    /** 5.类变量区 */
    public static String staticString ="static_string";

    /** 3.方法信息 */
    public static final String getStaticString() throws Exception {

        return ClassStruct.staticString;

    }

}




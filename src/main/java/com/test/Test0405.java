package com.test;

public class Test0405 {

    public static void main(String[] args) {
        StringBuffer a=new StringBuffer("a");
        StringBuffer b=new StringBuffer("b");
        function(a,b);
        System.out.println(a+" "+b);

        System.out.println();

        //Integer值在-128~127之间是值比较，Integer跟int也是值比较（自动拆箱机制）
        Integer i=-128;
        Integer j=-128;
        int x=-128;

        //显式创建对象的方式会导致额外的开销，选择直接赋值int类型值给Integer（自动装箱机制）
//        Integer n=new Integer(1);
        Integer n=1;

        System.out.println(i==j);
        System.out.println(i==x);

        System.out.println();

        String str1="java";
        String str2=new String(str1);
        System.out.println(str1==str2);
    }

    private static void function(StringBuffer x, StringBuffer y) {
        x=x.append(y);
        y=x;
    }
}

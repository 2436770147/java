package com.test;

public class Test0405 {

    public static void main(String[] args) {
        StringBuffer a=new StringBuffer("a");
        StringBuffer b=new StringBuffer("b");
        function(a,b);
        System.out.println(a+" "+b);

        System.out.println();
        System.out.println();

        //Integer值在-128~127之间是值比较，Integer跟int也是值比较（自动拆装箱机制）
        Integer i=-128;
        Integer j=-128;
        int x=-128;
        System.out.println(i==j);
        System.out.println(i==x);
    }

    private static void function(StringBuffer x, StringBuffer y) {
        x=x.append(y);
        y=x;
    }
}

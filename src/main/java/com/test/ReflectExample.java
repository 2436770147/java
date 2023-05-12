package com.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

//反射
public class ReflectExample {

    public static void main(String[] args) {
        try {
            //通过配置文件动态获取类对象、方法名
            Class<?> myClass = Class.forName(getValue("className"));
            Method myMethod = myClass.getDeclaredMethod(getValue("methodNmae"));
            //设置方法可访问
            myMethod.setAccessible(true);

            //获取公共字段
//            Field myField = myClass.getField("value");

            //获取所有类型字段
            Field myField = myClass.getDeclaredField("value");
            //设置字段可访问
            myField.setAccessible(true);
            System.out.println(myField.get(null));

            //获取公共构造方法，有参数需要传入参数类型
//            Constructor<?> myConstructor = myClass.getConstructor(String.class);

            //获取所有类型构造方法，有参数需要传入参数类型
            Constructor<?> myConstructor = myClass.getDeclaredConstructor(String.class);
            //设置构造方法可访问
            myConstructor.setAccessible(true);

            //实例化对象
            Object myInstance = myConstructor.newInstance("hello");

            //调用成员方法
            myMethod.invoke(myInstance);

            //通过反射越过泛型检查
            noGenericCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //根据key获取配置文件value
    public static String getValue(String key){
        //获取配置文件对象
        Properties properties=new Properties();
        //获取输入流
        try {
            FileReader in=new FileReader("D:\\Dev\\Java\\Idea_workspace\\my java\\src\\main\\resources\\my note\\reflect.Properties");
            //将流加载到配置文件对象中
            properties.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    //通过反射越过泛型检查
    public static void noGenericCheck() {
        ArrayList<String> list = new ArrayList<>();
        list.add("SpringBoot");
        list.add("Maven");

        //获取list类对象
        Class<?> listClass = list.getClass();
        try {
            //获取add方法反向调用添加
            Method method = listClass.getMethod("add", Object.class);
            method.invoke(list,666);
            System.out.println(list);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class MyClass {

    private static String value="java";

    private static String msg=null;

    private MyClass(String msg){
        this.msg=msg;
    }

    private void myMethod() {
        System.out.println("myMethod called with message: " + msg+" "+value);
    }
}
package com.test;

import java.util.LinkedHashMap;
import java.util.Map;

//手写LRU算法
public class LRUTest extends LinkedHashMap {

    //设置缓存容量
    private int capacity;

    public LRUTest(int capacity) {
        //调用父类的构造方法，(缓存容量、负载系数(默认0.75)、访问顺序：true：插入权重高；false：查询权重高)
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size()>capacity;
    }

    public static void main(String[] args) {
        LRUTest lruTest = new LRUTest(3);
        lruTest.put("a",1);
        lruTest.put("b",2);
        lruTest.put("c",3);
        System.out.println(lruTest.keySet());

        lruTest.put("d",4);
        System.out.println(lruTest.keySet());
    }
}

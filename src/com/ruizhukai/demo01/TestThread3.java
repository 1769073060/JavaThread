package com.ruizhukai.demo01;
/*
*第二种实现方式
* */
//第一步;写一个类实现java.lang.Runnable接口
//第二步;实现run方法

import org.junit.Test;

public class TestThread3{
    public static void main(String[] args) {
       int x=100;
        //创建线程
        Thread t = new Thread(new Prooessor1(){
            public void run() {
                for (int i = 0; i <x; i++) {
                    System.out.println("run---->" + i);
                }
            }
        });
        //启动
        t.start();


    }

}
//这种方式比较好   因为一个类实现接口之外保留了类的继承
class Prooessor1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            System.out.println("run---->" + i);
        }
    }
}

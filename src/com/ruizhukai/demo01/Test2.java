package com.ruizhukai.demo01;
public class Test2 {

    public static void main(String[] args) {


        TreadA threadA = new TreadA();
        //启动线程      就绪态 等待cpu分配时间片----》运行态
        threadA.start();


        System.out.println("111111");
        try {
            // 让当前前程阻塞 5000ms  睡觉
            // 在那个调用 哪个线程阻塞
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("222222");


    }
}

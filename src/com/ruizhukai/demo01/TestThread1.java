package com.ruizhukai.demo01;
//创建线程方式一 ：继承Thread类   重写run()方法   调用start开启线程
public class TestThread1 extends Thread{
    public void run(){
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---->"+ i);
        }
    }

    public static void main(String []args){
        //开启另一个线程    创建他的对象调用start();
        TestThread1 t = new TestThread1();
        t.run();
        t.start();//和主线程同时执行
        //main线程，主线程
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程"+ i);
        }
    }
}

package com.ruizhukai.demo01;
/*
* 休眠
* */
public class TestThread4 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread t = new Prooessor2();
        //休眠
        t.sleep(5000);

        //启动线程
        t.start();


    }
}
class Prooessor2 extends Thread{
    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("執行run方法" + i);
        }
    }
}

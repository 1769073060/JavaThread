package com.ruizhukai.demo01;

public class TestThread2 {
    /*
        第一步：继承java.lang.Thread
        第二步：重写run方法

        三个知识点：
               如何定义线程？
               如何创建线程？
               如何启动线程

    */
    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
        //创建线程
        Thread t = new Prooessor();
        //启动线程
        t.start();//这段代码执行瞬间消失，告诉JVM再分配一个新的栈给t线程

        //这是个普通方法调用，这样做程序只有一个线程，run方法结束后，下面程序才能继续执行
        t.run(); //run()不需要程序员手动调用，系统线程启动之后自动调用run方法
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程-->" + i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总共耗时"+(endTime-startTime) + "ms");
    }
}
class Prooessor extends Thread{
    //继承Thread类重写run方法
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("run---------->" + i);
        }
    }
}
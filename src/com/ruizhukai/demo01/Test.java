package com.ruizhukai.demo01;

public class Test {

    // java 应用的入口函数  main 是主线程
    public static void main(String[] args) {


        // 第一种方式创建线程  初始态
        TreadA threadA = new TreadA();
        //启动线程      就绪态 等待cpu分配时间片----》运行态
        threadA.start();

        // 线程优先级  做用就是提高线程的 一个cpu抢占的概率  优先级高被cpu 执行的概率就高
        //Thread.NORM_PRIORITY  5 默认优先级
        //Thread.MAX_PRIORITY   10 最大优先级
        // Thread.MIN_PRIORITY  1  最小优先级

        System.out.println("线程threadA的优先级："+threadA.getPriority());


    /*    try {
            // 等待 threadA 线程中的 run（）方法执行完毕 再执行下面的代码
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("treadA 执行完毕");*/

        // 第二种方式 通过Runnable 接口
        // ctrl + 左键  Thread(Runnable target)
        Runnable runnable = new ThreadB();
        Thread threadB = new Thread(runnable);

        threadB.setPriority(Thread.MAX_PRIORITY);

        threadB.start();



    }

}

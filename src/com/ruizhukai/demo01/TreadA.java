package com.ruizhukai.demo01;

/**
 * 通过继承 Thread 创建线程
 * 1 继承Tread
 * 2 重写 run()
 */
public class TreadA extends Thread {
    int o=100;
    @Override  // 当线程调用start() 后，run() 线程的任务开始执行
    public void run() {

        for (int i=0;i<o;i++){
            System.out.println("TreadA-i："+i);

            try {
                //每次for 循环 让 TreadA 睡100ms
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

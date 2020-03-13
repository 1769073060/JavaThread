package com.ruizhukai.demo01;

/**
 * 通过 Runnable接口创建
 */
public class ThreadB implements Runnable {
    @Override  // 执行对应线程任务
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("TreadB-i："+i);
        }
    }
}

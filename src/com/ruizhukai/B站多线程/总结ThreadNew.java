package com.rzk.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadNew {
    public static void main(String[] args) {
        //第一种创建方式   继承Thread
        new Thread1().start();
        //第二种创建方式   实现Runnable
        new Thread(new Thread2()).start();
        //第三种了解即可
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Thread3());
        new Thread(futureTask).start();

        try {
            Integer integer = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}



//1.继承Thread类
class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("继承");
    }
}
//2.实现Runnable接口
class Thread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("继承");

    }
}
//3.实现Callable接口
class Thread3 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread3");
        return 100;
    }
}
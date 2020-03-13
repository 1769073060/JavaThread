package com.rzk.util;

import java.util.concurrent.locks.ReentrantLock;

//測試lock鎖
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}
class TestLock2 implements  Runnable{
    int ticketNums = 10;

    //定義lock
    private final ReentrantLock lock= new ReentrantLock();

    @Override
    public void run(){
        while(true){
            try{
            lock.lock();//枷鎖
                if (ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else{
                    break;
                }
            }finally{
                //解鎖
                lock.unlock();
            }
        }
    }
}
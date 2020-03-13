package com.ruizhukai.demo01;

public class BankAccountTest {


    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        int m = 5000;


        // 创建线程 循环存钱
        Thread thread1 = new Thread(new Runnable() { // 匿名Runnable()接口实现类
            @Override
            public void run() {
                for (int i=0;i<m;i++){
                    try {
                        // 增大cpu 上下文切换 概率
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bankAccount.saveMoney(10);

                }
            }
        });
        thread1.start();

        // 创建线程循环取钱
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<m;i++){
                    try {
                        // 增大cpu 上下文切换 概率
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bankAccount.withDrawMoney(10);
                }
            }
        });
        thread2.start();


        try {

            // 等待两个线程  存钱 取钱 都运行结束
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(bankAccount.getBalance());

    }

}

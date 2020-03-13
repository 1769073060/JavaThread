package com.ruizhukai.demo01;

/**
 * 银行账户
 */
public class BankAccount {

    // 账户余额
    private float balance=100.0f;

    // 快捷键生成 getter方法


    public float getBalance() {
        return balance;
    }

    /**
     * 存钱
     * @param money
     */
    // synchronized  当前线程访问当前方法是 必须持有当前对象的 锁
    public synchronized void saveMoney(float money){
        balance = balance + money;

        // cpu真执行 balance = balance + money
        // 1         temp =  balance + money
        // 2         balance = temp
    }

    /**
     * 取钱
     * @param money
     */

    // 访问当前线程 也必须持有 当前对象的 锁
    public  void withDrawMoney(float money){

        // 执行当前 带代码块 也需要持有 当前对象的  锁
        synchronized (this){
            balance = balance - money;
        }

        // cpu真执行 balance = balance - money
        // 1         temp =  balance - money
        // 2         balance = temp
    }

    //synchronized 修饰静态方法 需要持有  当前类 锁    高并发环境下  性能特别差
    public synchronized static  void test(){
        System.out.println("test");
    }
}

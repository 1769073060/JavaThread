package com.ruizhukai.demo01;
/*
*
* t1和t2
*
* 异步变成模型： t1线程执行t1的    t2线程执行t2的   两个线程之间谁也不等谁
* 同步编程模型： t1线程和t2线程执行   当t1线程必须等t2线程执行结束之后，t1线程才能执行，这是同步编程模型
*
*
*  什么时候要同步呢？ 为什么要引入线程同步呢？
*   1.为了数据的安全，尽管应用程序的使用率降低，但是为了保证数据是安全的，必须加入线程同步机制
*
*   2.什么条件下要使用线程同步
*       第一，必须是多线程环境
*       第二,多线程环境共享同一个数据
*       第三，共享的数据涉及到修改操作
*
*
*   以下程序演示取款例子
* */
public class TestThread5 {
    public static void main(String[] args) {
       Account a = new Account("actno-001" ,500.0);
        System.out.println("余款" + a.getBalance() + "元");
       Prooessoes p = new Prooessoes(a);
       Thread t1 = new Thread(p);
       Thread t2 = new Thread(p);


       t1.start();
        t2.start();
    }
}
//取款线程
class Prooessoes implements Runnable{
    //账户
    Account act;

    //Constructor
    Prooessoes (Account act){
        this.act = act;
    }

    @Override
    public void run() {
        act.withdraw(100.0);


        System.out.println("取款成功" + act.getBalance());
    }
}

//账户
class Account{
    private String actno;//账户
    private double balance;//余额

    public Account(){}
    public Account(String actno,double balance){
        this.actno = actno;
        this.balance = balance;
    }

    public void setActno(String actno){
        this.actno = actno;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }
    public String getActno(){
        return actno;
    }
    //对外取款的方法
    public void withdraw(double money){//对当前账号进行取款操作
        //把需要同步的代码，放到同步语句块中
        /*
                原理：t1綫程和t2线程
                t1线程执行到此处，遇到了synchronized关键字,就会去找this的对象锁
                如果找到this对象锁，则进入同步语句块中执行程序，当替补语句块中的代码
                执行结束之后，t1线程归还this的对象锁

                在t1线程的同步语句块中，如果t2线程也过来执行以下代码，也遇到synchronized关键字
                ，所以也去找this的对象锁，但是该对象锁被t1线程持有
                只能在这等待this对象的归还
         */
        synchronized(this) {
            double after = balance - money;//剩余的钱=取款之前的金额-取款金额
            //延迟，使得线程有序排序
            try{
                Thread.sleep(1000);
            }
            catch (Exception e ){
                    e.printStackTrace();
            }
            //更新
            this.setBalance(after);
        }
    }
}
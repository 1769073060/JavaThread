package com.ruizhukai.demo01;

public class TestThread6 {
    public static void main(String[] args) throws InterruptedException {
        MyClass mo = new MyClass();
        Prooess p = new Prooess(mo);

        Thread t1 = new Thread(p);
        t1.setName("t1");
        Thread t2 = new Thread(p);
        t2.setName("t2");

        //启动线程
        t1.start();
        Thread.sleep(3000);
        t2.start();
    }
}
class Prooess implements Runnable{
    MyClass mo ;
    public Prooess(MyClass mo){
        this.mo = mo;
    }
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("t1")) {
            mo.m1();
        }
        if(Thread.currentThread().getName().equals("t2")){
            mo.m2();
         }
    }

}


class MyClass{
    public synchronized void m1(){
        //休眠
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("m1");
    }
//    public void m2(){//这里没有加锁
////        System.out.println("m2");
////    }
    public synchronized   void m2(){//同一把锁
        System.out.println("m2");
    }

}

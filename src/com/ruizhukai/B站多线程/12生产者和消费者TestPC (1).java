package com.rzk.util;


//生產者，消費這，測評 缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }

}
//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container=container;
    }

    //生产
    public void run(){
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println("消费了-->"+container.pop().id+"只鸡");
        }
    }
}

//产品
class Chicken{
    int id;//产品编号
    public Chicken(int id){
        this.id = id;
    }
}

//缓冲区
class SynContainer{

    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;


    //生产者放入产品
    public synchronized  void push(Chicken chicken){
        //  如果容器满了，就需要等待消费者消费
        if (count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果没有满，我们就丢入产品
        chickens[count]=chicken;
        count++;

        //就可以通着消费者消费
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if(count == 0){
            //消费者等待  生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //吃完就通知生产者生产
        this.notifyAll();
        return chicken;
    }
}













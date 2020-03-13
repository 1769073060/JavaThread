package com.rzk.util;

//死锁：多个线程相互抱着对方需要的资源，然后形成僵局
public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup1 = new Makeup(0,"小老虎");
        Makeup makeup2 = new Makeup(1,"小湖裏");

        makeup1.start();
        makeup2.start();
    }
}

//口红
class Lisptick{

}

//镜子
class Mirror{

}

class Makeup extends  Thread{
    //需要的资源只有一份，用static来保证只有一份
    static Lisptick lisptick = new Lisptick();
    static Mirror mirror = new Mirror();

    int choise;//选择
    String girlName;//使用化妆品的人

    public Makeup(int choise,String girlName){
        this.choise=choise;
        this.girlName=girlName;
    }

    public void run(){
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if(choise==0){
            //获得口红的锁
            synchronized(lisptick){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);

                synchronized(mirror){//一秒钟后获得镜子的锁
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }
        }else{
            //获得口红的锁
            synchronized(mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);

                synchronized(lisptick){//一秒钟后获得镜子的锁
                    System.out.println(this.girlName+"获得口红的锁");
                }
            }
        }
    }
}

















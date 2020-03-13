package com.rzk.util;

public class Race implements Runnable {
    //勝利者
    private static  String winner;
    @Override
    public void run() {

        for (int i = 0; i <=100; i++) {
            //判斷比赛是否结束
            boolean flag = gameOver(i);
            //如果比赛结束了  就停止程序
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--> 跑了"+i+" 步");
        }
    }
    //判斷是否完成比賽
    private boolean gameOver(int steps){
        //判斷是否有勝利這
        if (winner!=null){
            return true;
        }{
            if (steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is "+winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }


}

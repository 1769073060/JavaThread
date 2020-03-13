package com.rzk.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep {

    public static void main(String[] args) throws InterruptedException {
        //sleep打印系统时间
        Date startTime = new Date(System.currentTimeMillis());//获取当前时间

        while(true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime = new Date(System.currentTimeMillis());//更新当前时间

        }
    }
    //模拟倒计时
    public static void tenDown2() throws InterruptedException {
        int num=10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<0){
                break;
            }
        }
    }
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while(true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<0){
                break;
            }
        }
    }
}

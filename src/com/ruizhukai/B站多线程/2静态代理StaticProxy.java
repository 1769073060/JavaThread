package com.rzk.util;

import java.time.temporal.WeekFields;

public class StaticProxy {
    public static void main(String[] args) {
        new Thread( ()->System.out.println()).start();

        new WeddingCompany(new You()).HappyMarry();
//        WeddingCompany m =new WeddingCompany(new You());
//        m.HappyMarry();
    }
}


interface Marry{
    void HappyMarry();
}

class You implements  Marry{
    @Override
    public void HappyMarry() {
        System.out.println("要结婚了");
    }
}

class WeddingCompany implements Marry{
    private Marry marry;
    public WeddingCompany(Marry marry){
        this.marry=marry;
    }
    @Override
    public void HappyMarry() {
        after();
        this.marry.HappyMarry();
        before();
    }

    private void before() {
        System.out.println("结婚之后");
    }

    private void after() {
        System.out.println("结婚之前");
    }
}

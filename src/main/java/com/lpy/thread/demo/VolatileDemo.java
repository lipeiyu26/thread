package com.lpy.thread.demo;

import java.io.File;

public class VolatileDemo {
    public  volatile static  boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(()->{
            int i=0;
            while(!stop){
                i++;
//                System.out.println("rs:"+i);

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

//                synchronized (VolatileDemo.class){
//
//                }

                new File("txt.txt");
            }
//            System.out.println("rs:"+i);
        });
        a.start();
        Thread.sleep(1000);
        stop = true;
    }
}

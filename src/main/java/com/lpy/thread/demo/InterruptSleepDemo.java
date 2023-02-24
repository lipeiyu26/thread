package com.lpy.thread.demo;

import java.util.concurrent.TimeUnit;

public class InterruptSleepDemo implements Runnable{
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("1111");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {//jvm层面抛出的异常，触发了线程复位，标记为false
                e.printStackTrace();
                //interrupt()抛出异常之后线程复位，再次中断
                Thread.currentThread().interrupt();
            }
            System.out.println("22222");
        }
        System.out.println("end...");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptSleepDemo());
        thread.start();
        Thread.sleep(100);
        thread.interrupt();//会触发上面的异常，抛出异常

    }
}

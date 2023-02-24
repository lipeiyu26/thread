package com.lpy.thread.demo;

public class InterruptDemo implements Runnable{
    @Override
    public void run() {
        //Thread.currentThread().isInterrupted() 默认等于false，中断标记
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("run....");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        thread.interrupt();//设置interrupt标记为true
    }
}

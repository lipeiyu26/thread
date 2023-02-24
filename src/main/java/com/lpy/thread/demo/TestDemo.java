package com.lpy.thread.demo;

public class TestDemo extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("come in");
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.start();
        System.out.println("Main Thread....");
    }
}

package com.lpy.thread.demo;

public class AtomicityDemo {
    public static int count = 0;
    public static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count++;
    }
    public synchronized static void incr1(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count++;
    }
    public  static void incr2(){
        synchronized (AtomicityDemo.class){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }

    }
    public  static void incr3(){

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        synchronized (AtomicityDemo.class){
            count++;
        }

    }

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 1000; i++) {
//            new Thread(() -> AtomicityDemo.incr()).start();
//        }
//        Thread.sleep(3000);
//        System.out.println("运行结果"+ count);//结果是小于等于1000的随机数

//        for (int i = 0; i < 1000; i++) {
//            new Thread(() -> AtomicityDemo.incr1()).start();
//        }
//        Thread.sleep(3000);
//        System.out.println("运行结果"+ count);//结果是1000

//        for (int i = 0; i < 1000; i++) {
//            new Thread(() -> AtomicityDemo.incr2()).start();
//        }
//        Thread.sleep(3000);
//        System.out.println("运行结果"+ count);//结果是1000

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> AtomicityDemo.incr3()).start();
        }
        Thread.sleep(3000);
        System.out.println("运行结果"+ count);//结果是1000
    }
}

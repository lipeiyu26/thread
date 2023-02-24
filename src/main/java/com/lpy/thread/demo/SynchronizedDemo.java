package com.lpy.thread.demo;

import lombok.Synchronized;

public class SynchronizedDemo {

    synchronized void demo(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();
        SynchronizedDemo synchronizedDemo2 = new SynchronizedDemo();
        new Thread(()->{
            synchronizedDemo1.demo();
        },"t1").start();
        new Thread(()->{
            synchronizedDemo2.demo();
        },"t2").start();
    }
}

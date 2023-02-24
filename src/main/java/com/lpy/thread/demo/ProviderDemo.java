package com.lpy.thread.demo;

import java.util.Queue;

public class ProviderDemo extends Thread{
    private Queue<String>msg;
    private int maxSize;

    public ProviderDemo(Queue<String>msg,int maxSize){
        this.msg=msg;
        this.maxSize=maxSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            i++;
            synchronized (msg){
                while (msg.size() == maxSize){
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("生产者生产消息"+i);
                msg.add("生产消息"+i);
                msg.notify();//唤醒处于阻塞状态的线程

            }
        }
    }
}

package com.lpy.thread.demo;

import java.util.Queue;

public class ConsumerDemo extends  Thread{
    private Queue<String> msg;
    private int maxSzie;

    public ConsumerDemo(Queue<String> msg, int maxSzie) {
        this.msg = msg;
        this.maxSzie = maxSzie;
    }

    @Override
    public void run() {
        while (true){
            synchronized (msg){
                while (msg.isEmpty()){
                    try {
                        msg.wait();//如果当前线程满了，就阻塞当前线程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("消费者消费消息"+msg.remove());
                msg.notify();//唤醒处于阻塞状态的生产者线程
            }
        }
    }
}

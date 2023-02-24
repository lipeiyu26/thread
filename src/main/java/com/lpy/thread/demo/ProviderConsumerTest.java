package com.lpy.thread.demo;

import java.util.LinkedList;
import java.util.Queue;

public class ProviderConsumerTest {

    public static void main(String[] args) {
        Queue<String> msg = new LinkedList<>();
        int maxSize = 5;
        ProviderDemo providerDemo = new ProviderDemo(msg,maxSize);
        ConsumerDemo consumerDemo = new ConsumerDemo(msg,maxSize);

        Thread t1 = new Thread(providerDemo);
        Thread t2 = new Thread(consumerDemo);

        t2.start();
        t1.start();
    }
}

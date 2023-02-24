package com.lpy.thread.demo;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        System.out.println("come in");
        return "SUCCESS";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(callableDemo);
        System.out.println("111111");
        System.out.println(submit.get());
        System.out.println("222222");
    }
}

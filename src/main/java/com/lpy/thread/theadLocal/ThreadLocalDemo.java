package com.lpy.thread.theadLocal;

public class ThreadLocalDemo {
    private static int num = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                num += 5;
                System.out.println(Thread.currentThread().getName()+"_"+num);
            });
        }
        for (int i = 0; i < 5; i++) {//各个线程的顺序不一致，各个线程拿到的num不正确
            threads[i].start();
        }
    }
}

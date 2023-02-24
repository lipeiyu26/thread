package com.lpy.thread.theadLocal;

/**
 * ThreadLocal实现线程级别的资源隔离
 */
public class ThreadLocalDemo2 {
    static ThreadLocal<Integer> local = new ThreadLocal(){
        protected Integer initialValue(){
            return 0;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                local.set(local.get()+5);
                System.out.println(Thread.currentThread().getName()+"_"+local.get());
            });
        }
        for (int i = 0; i < 5; i++) {//各个线程的顺序不一致，各个线程拿到的num不正确
            threads[i].start();
        }
    }
}

package com.lpy.thread.join;

public class JoinDemo {
    private static int i=10;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() ->{
            i = 30;
        });
        t.start();
        //t线程中的执行结果对于main线程可见
        t.join(); // Happens-Before模型
        System.out.println("i:"+i);
    }
}

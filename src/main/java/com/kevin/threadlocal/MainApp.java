package com.kevin.threadlocal;

public class MainApp {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("th1");
                System.out.println("set th1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 get: " + threadLocal.get());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("th2");
                System.out.println("set th2");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 get: " + threadLocal.get());
            }
        });

        thread1.start();
        thread2.start();

    }
}

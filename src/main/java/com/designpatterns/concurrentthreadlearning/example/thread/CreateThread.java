package com.designpatterns.concurrentthreadlearning.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/9 13:41
 */
public class CreateThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //继承Thread
        Mythread mythread = new Mythread();
        mythread.start();
        Thread.sleep(500);
        //实现Runnable
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        //实现Callable
        MyCallable myCallable = new MyCallable();
        FutureTask task = new FutureTask(myCallable);
        Thread callThread = new Thread(task);
        callThread.start();
        System.out.println(task.get());

    }

    public static class Mythread extends Thread {
        @Override
        public void run() {
            int a = 0;
            while (true) {
                a++;
                this.setName(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + " ----- a = " + a);
                if (a == 1000) {
                    break;
                }
            }
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "~~~~~~~~> this is create implements Runnable");
        }
    }

    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "this is CallableInterface create~";
        }
    }
}

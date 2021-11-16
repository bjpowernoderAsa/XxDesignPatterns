package com.jucstudy.ThreadTest;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/6/7 16:39
 */
public class RunThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable runnable = new RunThread();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        System.out.println(Thread.activeCount());
    }
}

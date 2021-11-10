package com.designpatterns.concurrentthreadlearning.example.thread;

import com.designpatterns.concurrentthreadlearning.example.utils.ThreadSleepUtil;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/9 17:05
 */
public class JoinThread {

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JoinDemoThread(previous),"thread num " + String.valueOf(i));
            thread.start();
            previous = thread;
        }
        ThreadSleepUtil.SECONDS(1);
        System.out.println(Thread.currentThread().getName() + " @ terminate ~");
    }


    static class JoinDemoThread implements Runnable{
        private Thread thread;

        public JoinDemoThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " @ terminate ~");
        }
    }
}

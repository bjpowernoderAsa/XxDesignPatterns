package com.jucstudy.concurrentthreadlearning.example.thread;

import com.jucstudy.concurrentthreadlearning.example.utils.ThreadSleepUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件说明：wait  --->  notify/notifyAll唤醒
 *
 * @author XuBin
 * @createDT 2021/11/9 15:02
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread wait = new Thread(new Wait(),"wait Thread One ~ 110");
        wait.start();
        ThreadSleepUtil.SECONDS(1);
        Thread notify = new Thread(new Notify(),"notify Thread Two ~ 220");
        notify.start();
        notify.join();
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            //先加锁，监控，再判断条件
            synchronized (lock){
                while (flag){
                    try {
                        System.out.println(Thread.currentThread() + " this flag is true ,  Time " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //任务完成时执行
                System.out.println(Thread.currentThread() + " this flag is false , Time " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            //先加锁，再加操作，最后唤醒
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock. notify @  time = " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                System.out.println(" will sleep 2 SECONDS");
                ThreadSleepUtil.SECONDS(2);
            }
            //再加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ time = " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                System.out.println("will sleep 5 SECONDS");
                ThreadSleepUtil.SECONDS(5);
            }
        }
    }
}

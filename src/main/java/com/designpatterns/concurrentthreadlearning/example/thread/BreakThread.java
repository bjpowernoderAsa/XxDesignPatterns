package com.designpatterns.concurrentthreadlearning.example.thread;

import com.designpatterns.concurrentthreadlearning.example.utils.ThreadSleepUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件说明：线程中断一般使用变量控制
 *
 * @author XuBin
 * @createDT 2021/11/9 16:19
 */
public class BreakThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread,"BreakThread");
        thread.start();
        ThreadSleepUtil.SECONDS(1);
        myThread.cancal();
        MyThread myThread1 = new MyThread();
        Thread two = new Thread(myThread1,"BreakThread2");
        two.start();
        ThreadSleepUtil.SECONDS(1);
        two.isInterrupted();
    }

    static class MyThread implements Runnable{
        static volatile boolean flag = true;
        @Override
        public void run() {
            int i = 0;
            System.out.println(Thread.currentThread().getName() + " begin ,time = " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            while (flag && !Thread.currentThread().isInterrupted()){
                i ++;
            }
            System.out.println(Thread.currentThread().getName() + " this is flag = false, thread is break , i = " + i + ", time = " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
        public void cancal(){
            flag = false;
        }
    }
}

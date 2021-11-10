package com.designpatterns.concurrentthreadlearning.example.thread;

import com.designpatterns.concurrentthreadlearning.example.utils.ThreadSleepUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/9 17:20
 */
public class ThreadLocalTest {

    //第一次调用会初始化，后续线程都会调用一次
    private static final ThreadLocal<Long> TIME_THEREADLOCAL = ThreadLocal.withInitial(System::currentTimeMillis);

    //SimpleDateFormat不是线程安全的，所以每个线程都有自己的数据副本
    private static final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void begin(){
        System.out.println(Thread.currentThread().getName() + " begin at: " + dateFormat.get().format(new Date()));
        TIME_THEREADLOCAL.set(System.currentTimeMillis());
    }

    public static long end(){
        System.out.println(Thread.currentThread().getName() + " end at: " + dateFormat.get().format(new Date()));
        return System.currentTimeMillis() - TIME_THEREADLOCAL.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadLocalTest.begin();
                    ThreadSleepUtil.SECONDS(1);
                    System.out.println("Thread " + Thread.currentThread().getName() + " ~ ,Cost time : " + ThreadLocalTest.end() + "millis");
                }
            },"threadName " + i);
            thread.start();
        }
    }
}

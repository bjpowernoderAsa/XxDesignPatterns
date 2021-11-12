package com.designpatterns.concurrentthreadlearning.example.jmm;

import com.designpatterns.concurrentthreadlearning.example.utils.ThreadSleepUtil;

/**
 * 文件说明：监控器例子
 *
 * @author XuBin
 * @createDT 2021/11/12 15:26
 */
public class MonitorExample {
    int a = 0;

    private synchronized void writer() {
        System.out.println("~~~~~was start writer``````");
        a++;
        System.out.println("~~~~~was end writer```````");
    }

    private synchronized void reader() {
        System.out.println("~~~~~~was start reader``````");
        int t = a;
        System.out.println("*******was reader a = " + t);
        System.out.println("~~~~~~~was end reader````````");
    }

    public static void main(String[] args) {
        MonitorExample monitorExample = new MonitorExample();

       Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                monitorExample.writer();
                ThreadSleepUtil.SECONDS(1);
            }
        });

       Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                monitorExample.reader();
                ThreadSleepUtil.SECONDS(4);
            }
        });

        a.start();
        b.start();
    }
}

package com.jucstudy.concurrentthreadlearning.example.thread;

import com.jucstudy.concurrentthreadlearning.example.utils.ThreadSleepUtil;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/9 15:47
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonThreadOne(),"MyDaemon");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonThreadOne implements Runnable{

        @Override
        public void run() {
            try {
                ThreadSleepUtil.SECONDS(1);
            }finally {
                System.out.println("DaemonThread is run");
            }
        }
    }
}

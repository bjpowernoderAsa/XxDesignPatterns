package com.jucstudy.concurrentthreadlearning.example.utils;

import java.util.concurrent.TimeUnit;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/9 15:17
 */
public class ThreadSleepUtil {

    public static void SECONDS(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

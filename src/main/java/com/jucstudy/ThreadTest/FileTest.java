package com.jucstudy.ThreadTest;


import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.*;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/6/9 11:30
 */
public class FileTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int a = i;
            Thread.sleep(1000);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"---------------------"+a);
                }
            });
        }
        
    }
}

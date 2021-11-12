package com.designpatterns.concurrentthreadlearning.example.jmm;

import com.designpatterns.concurrentthreadlearning.example.utils.ThreadSleepUtil;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/12 15:09
 */
public class VolatileDemo {

    public static boolean flag = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!flag){
                    i ++;
                    System.out.println("~!~~~~~~~~~~~~ i = " + i);
                }
            }
        },"tOne").start();
        ThreadSleepUtil.SECONDS(1);
        System.out.println("This is sleep end!~~~~~~~~~~~~~~~~~~~~~");
        flag = true;
    }
}

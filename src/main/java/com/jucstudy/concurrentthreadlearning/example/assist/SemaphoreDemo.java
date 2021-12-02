package com.jucstudy.concurrentthreadlearning.example.assist;

import com.jucstudy.concurrentthreadlearning.example.utils.ThreadSleepUtil;

import java.util.concurrent.Semaphore;

/**
 * 文件说明：信号标量
 *          模拟场景六辆车，抢占三个车位
 *
 * @author XuBin
 * @createDT 2021/12/1 13:28
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    //进行抢占
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " -号小车进入停车位");
                    ThreadSleepUtil.SECONDS(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放车位信号
                    semaphore.release(1);
                    System.out.println(Thread.currentThread().getName() + " -号小车离开停车位~~~~~");
                }
            },String.valueOf(i)).start();
        }
    }

}
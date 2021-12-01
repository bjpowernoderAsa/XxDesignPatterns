package com.jucstudy.concurrentthreadlearning.example.assist;

import java.util.concurrent.CountDownLatch;

/**
 * 文件说明：减少计数
 *
 * 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
 *
 * 用给定的计数 初始化 CountDownLatch。由于调用了 countDown() 方法，
 * 所以在当前计数到达零之前，await 方法会一直受阻塞。之后，会释放所有等待的线程，await 的所有后续调用都将立即返回。
 * 这种现象只出现一次——计数无法被重置。如果需要重置计数，请考虑使用 CyclicBarrier。
 *
 * CountDownLatch 是一个通用同步工具，它有很多用途。
 * 将计数 1 初始化的 CountDownLatch 用作一个简单的开/关锁存器，
 * 或入口：在通过调用 countDown() 的线程打开入口前，所有调用 await 的线程都一直在入口处等待。
 * 用 N 初始化的 CountDownLatch 可以使一个线程在 N 个线程完成某项操作之前一直等待，或者使其在某项操作完成 N 次之前一直等待。
 *
 * CountDownLatch 的一个有用特性是，它不要求调用 countDown 方法的线程等到计数到达零时才继续，而在所有线程都能通过之前，它只是阻止任何线程继续通过一个 await。
 *
 *          模拟场景：所有人陆续离开教室，班长锁门
 *
 * @author XuBin
 * @createDT 2021/12/1 9:18
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        int threadCount = 10;

        final CountDownLatch latch = new CountDownLatch(threadCount);

        System.out.println("下课啦~~~");

        for(int i=0; i< threadCount; i++){
            new Thread(() -> {
                System.out.println("学生" + Thread.currentThread().getId() + "号，已离开班级");
                    latch.countDown();
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("班长锁门离开~~~~");
    }

}

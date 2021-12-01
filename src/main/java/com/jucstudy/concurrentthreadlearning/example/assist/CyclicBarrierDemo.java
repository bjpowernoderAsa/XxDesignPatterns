package com.jucstudy.concurrentthreadlearning.example.assist;

import java.util.concurrent.CyclicBarrier;

/**
 * 文件说明：循环栅栏，循环同步器
 *
 * 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。
 * 在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。
 * 因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier。
 *
 * CyclicBarrier 支持一个可选的 Runnable 命令，在一组线程中的最后一个线程到达之后（但在释放所有线程之前），该命令只在每个屏障点运行一次。
 * 若在继续所有参与线程之前更新共享状态，此屏障操作 很有用。
 *
 *          模拟场景：收集相应数量卡片数量，执行兑换
 *
 *
 *
 * @author XuBin
 * @createDT 2021/12/1 10:46
 */
public class CyclicBarrierDemo {
    //设置需要收集卡片数量
    private static final int NUMBER = 7;


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,() -> {
            System.out.println("******卡片已收集齐，可兑换大奖");
        });

        for (int i = 0; i < NUMBER ; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getId()+"卡片，被收集到了~");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

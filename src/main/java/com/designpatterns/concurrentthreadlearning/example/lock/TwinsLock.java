package com.designpatterns.concurrentthreadlearning.example.lock;


import com.designpatterns.concurrentthreadlearning.example.utils.ThreadSleepUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/10 10:41
 */
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count){
            if (count <= 0){
                throw new IllegalArgumentException("count must large than zero~");
            }
            setState(count);
        }

        @Override
        public int tryAcquireShared(int reduceCount){
            for (;;){
                int current = getState();
                int newCount = current - reduceCount;
                if (current < 0 && compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        public boolean tryReleaseShared(int returnCount){
            for (;;){
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }
    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        class Work extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        ThreadSleepUtil.SECONDS(1);
                        System.out.println(Thread.currentThread().getName());
                        ThreadSleepUtil.SECONDS(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Work work = new Work();
            work.setName("Thread name = "+i);
            work.setDaemon(true);
            work.start();
        }

        for (int i = 0; i < 10; i++) {
            ThreadSleepUtil.SECONDS(1);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(Thread.currentThread().getName());
        }
    }
}

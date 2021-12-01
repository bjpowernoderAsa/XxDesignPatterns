package com.jucstudy.concurrentthreadlearning.example.assist;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 文件说明：让线程按顺序执行,使用Condition
 *
 * @author XuBin
 * @createDT 2021/11/30 13:33
 */
public class LockConditionController {

    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

}

//创建共享资源  辅助器
class ShareRes{
    private int flag = 1;  //1,2,3,,,表示不同线程
    //创建锁
    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();

    private Condition conditionB = lock.newCondition();

    private Condition conditionC = lock.newCondition();

}

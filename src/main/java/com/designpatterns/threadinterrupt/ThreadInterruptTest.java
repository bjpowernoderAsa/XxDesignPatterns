package com.designpatterns.threadinterrupt;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/8 14:21
 */
public class ThreadInterruptTest {

    public static void main(String[] args) {

    }

    private static class MyRunanble implements Runnable {

        private static int a = 0;

        private static volatile  boolean on = false;

        @Override
        public void run() {

        }
    }

    public void cannal(){
        MyRunanble.on = true;
    }
}
package com.designpatterns.concurrentthreadlearning.example.thread;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/9 14:46
 */
public class ThreadInterrupted {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1);
        myThread.interrupt();  //线程中断
    }

    public static class MyThread extends Thread{
        @Override
        public void run() {
            int a = 0;
            while (true){
                System.out.println(this.getName() + " this is a = " + a++);
                if (this.isInterrupted()){  //检测当前线程是否被中断
                    System.out.println(this.getName() + " isInterrupted~");
                    break;
                }
            }
        }
    }
}

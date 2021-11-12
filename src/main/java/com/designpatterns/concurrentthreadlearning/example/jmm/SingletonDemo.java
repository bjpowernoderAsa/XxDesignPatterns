package com.designpatterns.concurrentthreadlearning.example.jmm;

/**
 * 文件说明：并发创建单例
 *
 * @author XuBin
 * @createDT 2021/11/12 15:17
 */
public class SingletonDemo {

    private static SingletonDemo singletonDemo;

    public SingletonDemo() {

    }

    public SingletonDemo createSingletonOne(){  //使用双重检查锁
        if (null == singletonDemo){
            //针对类对象加锁
            synchronized (SingletonDemo.class){
                if (null == singletonDemo){
                    return singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

}

package com.designpatterns.learnAgrent;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 15:36
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("This is RealSubject!~");
    }
}

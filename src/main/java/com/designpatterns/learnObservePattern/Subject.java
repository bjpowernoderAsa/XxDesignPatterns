package com.designpatterns.learnObservePattern;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 14:00
 */
public interface Subject {

    void add(Observe observe);

    void del(Observe observe);

    void notifyObserve();

    void operation();
}

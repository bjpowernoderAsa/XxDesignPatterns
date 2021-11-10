package com.designpatterns.learnObservePattern;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 14:16
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observe> vector = new Vector<>();

    @Override
    public void add(Observe observe) {
        vector.add(observe);
    }

    @Override
    public void del(Observe observe) {
        vector.remove(observe);
    }

    @Override
    public void notifyObserve() {
        Enumeration<Observe> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            enumeration.nextElement().update();
        }
    }

}

package com.designpatterns.learnObservePattern;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 14:57
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new OperationSubject();
        subject.add(new ObserveObjectOne());
        subject.add(new ObserveObjectTwo());
        subject.operation();
        subject.del(new ObserveObjectTwo());
        subject.operation();
    }
}

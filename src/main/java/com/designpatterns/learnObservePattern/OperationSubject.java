package com.designpatterns.learnObservePattern;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 14:58
 */
public class OperationSubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("This is update self!");
        notifyObserve();
    }
}

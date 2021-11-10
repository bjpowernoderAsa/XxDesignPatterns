package com.designpatterns.learnObservePattern;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 13:58
 */
public class ObserveObjectTwo implements Observe {
    @Override
    public void update() {
        System.out.println("This is ObserveTwo has received!");
    }
}

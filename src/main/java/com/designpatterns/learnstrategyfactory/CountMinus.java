package com.designpatterns.learnstrategyfactory;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 11:14
 */
public class CountMinus implements Count {
    @Override
    public int getNum(int num1, int num2) {
        return num1 - num2;
    }
}

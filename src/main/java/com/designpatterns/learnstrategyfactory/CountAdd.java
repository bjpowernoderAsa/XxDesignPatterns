package com.designpatterns.learnstrategyfactory;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 11:13
 */
public class CountAdd implements Count {
    @Override
    public int getNum(int num1, int num2) {
        return num1+num2;
    }
}

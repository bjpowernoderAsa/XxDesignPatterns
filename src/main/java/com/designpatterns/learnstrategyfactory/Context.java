package com.designpatterns.learnstrategyfactory;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 11:16
 */
public class Context {
    private Count count;

    public Context(Count count) {
        this.count = count;
    }

    public int OperationNum(int num1, int num2){
        return count.getNum(num1,num2);
    }

}

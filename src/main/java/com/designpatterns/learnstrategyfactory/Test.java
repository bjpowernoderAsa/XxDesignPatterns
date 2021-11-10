package com.designpatterns.learnstrategyfactory;

import com.designpatterns.learnsingle.SingleObject;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 11:15
 */
public class Test {

    public static void main(String[] args) {
        //策略模式
        Context context = new Context(new CountAdd());
        System.out.println("10 + 5 = "+context.OperationNum(10,5));
        Context text = new Context(new CountMinus());
        System.out.println("8 - 3 = "+text.OperationNum(8,3));

        SingleObject singleObject = SingleObject.getInstance();
        singleObject.setName("This is singleObject");
        System.out.println(singleObject.getName());
    }
}

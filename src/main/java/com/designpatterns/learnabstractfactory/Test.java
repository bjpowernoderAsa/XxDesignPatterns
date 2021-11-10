package com.designpatterns.learnabstractfactory;

import com.designpatterns.learn.Send;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/10 14:37
 */
public class Test {
    public static void main(String[] args) {
        Provide provide = new PhoneFactory();
        Send send = provide.produce();
        send.sendInfo();
    }
}

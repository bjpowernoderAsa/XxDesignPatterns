package com.designpatterns.learn;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/10 13:37
 */
public class PhoneSend implements Send {

    @Override
    public void sendInfo() {
        System.out.println("This is PhoneInfo");
    }

}

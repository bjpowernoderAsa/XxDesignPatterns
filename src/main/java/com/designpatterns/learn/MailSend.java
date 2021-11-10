package com.designpatterns.learn;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/10 13:35
 */
public class MailSend implements Send {

    @Override
    public void sendInfo() {
        System.out.println("This is MailInfo");
    }

}

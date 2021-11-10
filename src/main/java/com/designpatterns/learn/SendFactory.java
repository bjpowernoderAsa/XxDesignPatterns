package com.designpatterns.learn;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/10 13:39
 */
public class SendFactory {

    public static Send produceMail(){
        return new MailSend();
    }

    public static Send producePhone(){
        return new PhoneSend();
    }

}

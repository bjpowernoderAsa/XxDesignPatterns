package com.designpatterns.learnabstractfactory;

import com.designpatterns.learn.MailSend;
import com.designpatterns.learn.Send;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/10 14:36
 */
public class MailFactory implements Provide {

    @Override
    public Send produce() {
        return new MailSend();
    }
}

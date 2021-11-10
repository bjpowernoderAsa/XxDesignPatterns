package com.designpatterns.learnabstractfactory;

import com.designpatterns.learn.PhoneSend;
import com.designpatterns.learn.Send;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/10 14:37
 */
public class PhoneFactory implements Provide {
    @Override
    public Send produce() {
        return new PhoneSend();
    }

}

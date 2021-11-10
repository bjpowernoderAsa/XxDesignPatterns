package com.designpatterns.learnAgrent;

/**
 * 文件说明：模板
 *
 * @author XuBin
 * @createDT 2021/5/11 15:37
 */
public class ProxySubject implements Subject{

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("begin~");
        subject.request();
        System.out.println("end~");
    }
}

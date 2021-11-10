package com.designpatterns.learnAgrent;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 15:40
 */
public class Test {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(realSubject);
        proxySubject.request();
    }
}

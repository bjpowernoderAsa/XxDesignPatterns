package com.designpatterns.learn;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        Send send = SendFactory.produceMail();
        send.sendInfo();
        send = SendFactory.producePhone();
        send.sendInfo();
    }
}

package com.jucstudy.ThreadTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/6/7 16:36
 */
public class LearningThread extends Thread {

    public static void main(String[] args) {
//        LearningThread thread = new LearningThread();
//        thread.start();
//        LearningThread thread1 = new LearningThread();
//        thread1.start();
//        String regex = "[a-zA-Z0-9\\\\-]";
//        String regex = "\"^[a-zA-Z]\\w{5,17}$\"";
        String regex = "^\\d{4}-\\d{1,2}-\\d{1,2}";
//        String regex = "^(0?[1-9]|1[0-2])$";
//        String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
        String a = "2020-11-13";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);

        boolean tem = matcher.matches();
        System.out.println("----"+tem);
    }


    @Override
    public void run() {
        System.out.println(LearningThread.currentThread().getName());
    }
}

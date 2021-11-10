package com.designpatterns.learntemplatefactory;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/27 13:46
 */
public class TestSwitch {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            String param = "c";
            System.out.println("=================================");
            System.out.println("------------->>--"+i);
            switch (param){
                case "a":
                    System.out.println("1");
                    break;
                case "b":
                    System.out.println("2");
                    break;
                case "c":
                    System.out.println("3");
                    break;
                    default:
            }
            System.out.println("---------------<<---"+i);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}

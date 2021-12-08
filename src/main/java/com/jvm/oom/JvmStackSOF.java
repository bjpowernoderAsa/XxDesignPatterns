package com.jvm.oom;

/**
 * 文件说明：
 * VM Args：-Xss128k
 * @author XuBin
 * @createDT 2021/12/8 11:28
 */
public class JvmStackSOF {

    private int stackLength = 1;

    public void stackLength(){
        stackLength ++;
        stackLength();
    }

    public static void main(String[] args) {
        JvmStackSOF jvmStackSOF = new JvmStackSOF();
        try {
            jvmStackSOF.stackLength();
        }catch (Exception e){
            System.out.println("stack length:" + jvmStackSOF.stackLength);
            throw e;
        }
    }

}

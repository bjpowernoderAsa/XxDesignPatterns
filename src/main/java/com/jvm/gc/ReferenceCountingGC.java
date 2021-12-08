package com.jvm.gc;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/12/8 15:50
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int num = 1024 * 1024;

    private byte[] bize = new byte[2*num];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();
    }
}

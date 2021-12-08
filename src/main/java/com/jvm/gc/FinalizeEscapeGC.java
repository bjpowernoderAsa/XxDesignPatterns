package com.jvm.gc;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/12/8 16:04
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC finalizeEscapeGC = null;

    public void alive(){
        System.out.println("yes,I am alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Executor finalize method~");
        FinalizeEscapeGC.finalizeEscapeGC = this;
    }

    public static void main(String[] args) throws InterruptedException {
        finalizeEscapeGC = new FinalizeEscapeGC();
        finalizeEscapeGC = null;
        System.gc();
        Thread.sleep(500);
        if (finalizeEscapeGC != null){
            finalizeEscapeGC.alive();
        }else {
            System.out.println("I am dead~");
        }
        System.out.println("let us again alive~");
        finalizeEscapeGC = null;
        System.gc();
        Thread.sleep(500);
        if (finalizeEscapeGC != null){
            finalizeEscapeGC.alive();
        }else {
            System.out.println("I am dead~");
        }

    }
}

package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件说明：限制Java堆的大小为20MB，不可扩展（将堆的最小值-Xms参数与最大值-Xmx参数 设置为一样即可避免堆自动扩展）
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author XuBin
 * @createDT 2021/12/8 11:21
 */
public class HeapOOM {

    static class ObjectOOM{

    }

    public static void main(String[] args) {
        List<ObjectOOM> list = new ArrayList<>();
        while (true){
            list.add(new ObjectOOM());
        }
    }

}

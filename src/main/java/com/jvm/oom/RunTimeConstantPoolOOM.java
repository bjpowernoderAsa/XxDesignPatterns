package com.jvm.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * 文件说明：
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
 * @author XuBin
 * @createDT 2021/12/8 15:36
 */
public class RunTimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        Short i = 1;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }

}

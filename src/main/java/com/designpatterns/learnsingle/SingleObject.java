package com.designpatterns.learnsingle;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/11 13:22
 */
public class SingleObject {

    private String Name;

    private static SingleObject instance = new SingleObject();

    private SingleObject() {

    }

    public static SingleObject getInstance(){
        return instance;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
}

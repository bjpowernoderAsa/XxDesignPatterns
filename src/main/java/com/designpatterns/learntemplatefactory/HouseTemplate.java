package com.designpatterns.learntemplatefactory;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/13 10:57
 */
public abstract class HouseTemplate {

    private String name;

    public HouseTemplate(String name) {
        this.name = name;
    }

    protected abstract void BuildDoor();

    protected abstract void BuildWindow();

    protected abstract void BuildBase();

    protected abstract void BuildWall();

    public final void BuildStart(){
        BuildBase();
        BuildWall();
        BuildWindow();
        BuildDoor();
    }
}

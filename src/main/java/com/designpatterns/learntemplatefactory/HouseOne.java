package com.designpatterns.learntemplatefactory;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/13 11:14
 */
public class HouseOne extends HouseTemplate {

    public HouseOne(String name) {
        super(name);
    }

    @Override
    protected void BuildDoor() {
        System.out.println("");
    }

    @Override
    protected void BuildWindow() {
        System.out.println("");
    }

    @Override
    protected void BuildBase() {
        System.out.println("");
    }

    @Override
    protected void BuildWall() {
        System.out.println("");
    }
}

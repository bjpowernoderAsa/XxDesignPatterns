package com.regex;

/**
 * 文件说明：特殊字符
 *
 * @author XuBin
 * @createDT 2021/11/18 15:52
 */

public enum SpecialToken {

    ASTERISK('*',6,true,true),
//    POINT('.',6,true,true),
    PLUS('+',6,true,true),
    QUESTION('?',6,true,true),
    L_PARENTHESIS('(',9,false,false),
    R_PARENTHESIS(')',9,true,false),
    OR('|',3,false,true),
    CONCAT('7',4,false,true),
    ;

    //优先级
    private int priority;
    //象征
    private char symbol;
    //能结束
    private boolean canBeEnd;
    //需要前置
    private boolean needsPreceding;

    SpecialToken(char symbol, int priority, boolean canBeEnd, boolean needsPreceding) {
        this.priority = priority;
        this.symbol = symbol;
        this.canBeEnd = canBeEnd;
        this.needsPreceding = needsPreceding;
    }

    public int getPriority() {
        return priority;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isCanBeEnd() {
        return canBeEnd;
    }

    public boolean isNeedsPreceding() {
        return needsPreceding;
    }
}

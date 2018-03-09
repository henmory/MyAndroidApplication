package com.henmory.designpattern.design_pattern.Asingleton;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description: 饿汉型
 */

public class SingleTon1 {
    private final static SingleTon1 singleTon = new SingleTon1();

    private SingleTon1() {
    }

    public static SingleTon1 getInstance(){
        return singleTon;
    }
}

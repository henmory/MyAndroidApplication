package com.henmory.designpattern.design_pattern.Asingleton;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public class SingleTon3 {

    private SingleTon3() {
    }

    public static SingleTon3 getInstance(){
        return InnerStaticClass.SingleTon3;
    }

    private static class InnerStaticClass{
        private final static SingleTon3 SingleTon3 = new SingleTon3();
    }
}

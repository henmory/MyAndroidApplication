package com.henmory.designpattern.design_pattern.Rtemplatemethod;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description:
 */

public abstract class AbstractBank {

    public void takeNumber(){
        System.out.println("我要取号");
    }

    public abstract void transact();

    public void evaluate(){
        System.out.println("我要评价你的服务");
    }

    //模版方法，声明为final，表示子类不能从写，我个人决定可以声明为private这样子类肯定不可以重写
    //关键点在于这个方法，封装了一个固定的模版，该模版调用顺序不会改变
    //同时，某个方法延迟到子类去实现，不同的子类可能有不同的实现方式
    public final void process(){
        takeNumber();
        transact();
        evaluate();
    }
}

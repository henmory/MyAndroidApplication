package com.henmory.designpattern.design_pattern.Bfactory.simplefactory;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public class Test {

    public static void main(String[] arg){
        //调用者需要知道如何构造汽车，还要知道如何使用
//        ICar byd = new BYD();
//        ICar benzi = new Benzi();
//        benzi.run();
//        byd.run();


        //调用者只需要知道如何调用即可，具体怎么创建它不管
        ICar byd = SimpleFactory.createCar("BYD");
        byd.run();
    }
}

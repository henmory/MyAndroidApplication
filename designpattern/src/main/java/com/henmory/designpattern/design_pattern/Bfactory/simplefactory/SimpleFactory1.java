package com.henmory.designpattern.design_pattern.Bfactory.simplefactory;


/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public class SimpleFactory1 {

    public static ICar createBYD(){
        return new BYD();
    }

    public static ICar createBenzi(){
        return new Benzi();
    }
}

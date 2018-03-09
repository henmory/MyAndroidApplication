package com.henmory.designpattern.design_pattern.Bfactory.simplefactory;


/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public class SimpleFactory {

    public static ICar createCar(String name){
        if(name.equals("BYD")){
            return new BYD();
        }else if(name.equals("Benzi")){
            return new Benzi();
        }else {
            return null;
        }
    }
}

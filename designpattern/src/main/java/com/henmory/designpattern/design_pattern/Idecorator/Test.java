package com.henmory.designpattern.design_pattern.Idecorator;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description: 装饰者设计模式没，是装饰对象的排列组合，减少了类的数量
 */

public class Test {

    public static void main(String[] args){
        Car car = new Car();
        car.move();


        //传入要装饰的对象
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        //传入要装饰的对象
        WaterCar waterCar = new WaterCar(car);
        flyCar.move();

        //car为要装饰的对象，flycar装饰完之后，watercar又装饰了一次
        WaterCar waterCar1 = new WaterCar(new FlyCar(new Car()));
        waterCar1.move();
    }
}

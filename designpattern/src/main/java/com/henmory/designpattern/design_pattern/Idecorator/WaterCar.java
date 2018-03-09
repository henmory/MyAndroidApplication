package com.henmory.designpattern.design_pattern.Idecorator;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description:实际的装饰者
 */

public class WaterCar extends CarDecorator {

    public WaterCar(Icar icar) {
        super(icar);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("我还会游泳");
    }
}

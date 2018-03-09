package com.henmory.designpattern.design_pattern.Idecorator;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description: 装饰者的基类，所有的装饰着都继承自它
 *              它持有被装饰者的一个引用，
 */

public class CarDecorator implements Icar {

    protected Icar icar;

    public CarDecorator(Icar icar) {
        this.icar = icar;
    }

    @Override
    public void move() {
        icar.move();
    }
}

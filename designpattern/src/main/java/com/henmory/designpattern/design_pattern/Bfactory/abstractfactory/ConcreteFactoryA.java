package com.henmory.designpattern.design_pattern.Bfactory.abstractfactory;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public class ConcreteFactoryA implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ConcreteGoodProduceA();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteGoodProduceB();
    }

    @Override
    public AbstractProductC createProductC() {
        return new ConcreteGoodProduceC();
    }
}

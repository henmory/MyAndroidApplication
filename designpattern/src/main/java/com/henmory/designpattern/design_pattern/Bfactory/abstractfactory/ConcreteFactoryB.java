package com.henmory.designpattern.design_pattern.Bfactory.abstractfactory;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public class ConcreteFactoryB implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ConcreteBadProduceA();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteBadProduceB();
    }

    @Override
    public AbstractProductC createProductC() {
        return new ConcreteBadProduceC();
    }
}

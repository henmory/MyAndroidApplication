package com.henmory.designpattern.design_pattern.Bfactory.abstractfactory;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
    AbstractProductC createProductC();
}

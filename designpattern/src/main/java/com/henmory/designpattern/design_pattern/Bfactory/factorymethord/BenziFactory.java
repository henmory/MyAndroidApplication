package com.henmory.designpattern.design_pattern.Bfactory.factorymethord;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public class BenziFactory implements CarFactory {
    @Override
    public ICar createCar() {
        return new Benzi();
    }
}

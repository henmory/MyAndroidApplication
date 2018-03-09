package com.henmory.designpattern.design_pattern.Nmediator;

/**
 * author: henmory
 * time:  2/25/18
 * function:
 * description:
 */

public class Financial implements Department{

    private Mediator mediator;

    public Financial(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.register("Financial", this);
    }

    @Override
    public void selfAction() {
        System.out.println("发钱");
    }

    @Override
    public void outAction() {
        System.out.println("报人数");
    }
}

package com.henmory.designpattern.design_pattern.Nmediator;

/**
 * author: henmory
 * time:  2/25/18
 * function:
 * description:
 */

public class Market implements Department{

    private Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.register("Market", this);
    }

    @Override
    public void selfAction() {
        System.out.println("市场调研");
    }

    @Override
    public void outAction() {
        System.out.println("资金不够需要财务部支持");
        mediator.command("Financial");
    }
}

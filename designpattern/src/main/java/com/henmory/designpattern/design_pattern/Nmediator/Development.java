package com.henmory.designpattern.design_pattern.Nmediator;

/**
 * author: henmory
 * time:  2/25/18
 * function:
 * description:
 */

public class Development implements Department {
    private Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.register("Development", this);
    }

    @Override
    public void selfAction() {
        System.out.println("开发项目");
    }

    @Override
    public void outAction() {
        System.out.println("请求给予跟多资金支持");
        this.mediator.command("Financial");
    }
}

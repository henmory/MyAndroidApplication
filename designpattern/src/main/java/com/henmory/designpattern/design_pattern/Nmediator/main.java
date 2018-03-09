package com.henmory.designpattern.design_pattern.Nmediator;

/**
 * author: henmory
 * time:  2/25/18
 * function:
 * description:
 */

public class main {

    public static void main(String[] args){
        Mediator mediator = new Manager();

        Development development = new Development(mediator);
        Market market = new Market(mediator);
        Financial financial = new Financial(mediator);

        development.selfAction();
        market.selfAction();
        financial.selfAction();

        development.outAction();
    }
}

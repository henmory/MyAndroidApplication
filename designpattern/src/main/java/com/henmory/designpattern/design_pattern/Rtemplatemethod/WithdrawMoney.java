package com.henmory.designpattern.design_pattern.Rtemplatemethod;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description: 子类实现父类的抽象方法，这样对于不同的子类，取钱业务的流程是一样的，但是取钱的内容可能有差别
 *              这样每个子类通过复写不同的transact方法，既可实现
 */

public class WithdrawMoney extends AbstractBank {
    @Override
    public void transact() {
        System.out.println("我要取钱");
    }
}

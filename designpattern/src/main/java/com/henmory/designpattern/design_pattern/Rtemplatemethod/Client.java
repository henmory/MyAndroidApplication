package com.henmory.designpattern.design_pattern.Rtemplatemethod;

/**
 * author: henmory
 * time:  2/11/18
 * function:
 * description:
 */

public class Client {

    public static void main(String[] arg){

        //客户1
        AbstractBank bank = new WithdrawMoney();
        bank.process();


        //客户2===>匿名内部类
        //子类复写父类的抽象方法，然后子类调用父类的方法，进而最终调用到自己实现的方法
        AbstractBank bank1 = new AbstractBank() {
            @Override
            public void transact() {
                System.out.println("我要存钱");
            }
        };
        bank1.process();

        //客户3
        AbstractBank bank2 = new AbstractBank() {
            @Override
            public void transact() {
                System.out.println("我要存加元");
            }
        };
        bank2.process();

    }

}

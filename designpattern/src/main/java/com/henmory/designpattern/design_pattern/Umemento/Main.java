package com.henmory.designpattern.design_pattern.Umemento;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public class Main {

    public static void main(String[] args){

        CareTaker careTaker = new CareTaker();

        Originator originator = new Originator("韩卯辉", 19 + "", 232 + "");
        System.out.println("第一次打印" + originator.getName() + "---");

        careTaker.setMemento(originator.memento());

        originator.setName("henmory");
        System.out.println("第二次打印" + originator.getName() + "---");

        originator.recover(careTaker.getMemento());
        System.out.println("第三次打印" + originator.getName() + "---");

    }
}

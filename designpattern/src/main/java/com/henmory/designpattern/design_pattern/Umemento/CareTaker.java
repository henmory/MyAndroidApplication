package com.henmory.designpattern.design_pattern.Umemento;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:保存备忘数据
 */

public class CareTaker {
    private Memento memento;
    //private List<Memento> memento =  new ArrayList<>(); 多个备忘份

    public CareTaker() {
    }

    public CareTaker(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

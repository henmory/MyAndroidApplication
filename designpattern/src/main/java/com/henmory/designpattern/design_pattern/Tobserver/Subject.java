package com.henmory.designpattern.design_pattern.Tobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * author: henmory
 * time:  2/28/18
 * function:
 * description:
 */

public class Subject {

    protected List<Observer> list =  new ArrayList<>();

    public void register(Observer observer){
        list.add(observer);
    }
    public void unregister(Observer observer){
        list.remove(observer);
    }

    public void nofifyObserver(){
        for (int i  = 0; i < list.size(); i++){
            list.get(i).update(this);
        }
    }


}

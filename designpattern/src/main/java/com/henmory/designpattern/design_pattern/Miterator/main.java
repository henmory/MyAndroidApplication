package com.henmory.designpattern.design_pattern.Miterator;

import java.util.Iterator;

/**
 * author: henmory
 * time:  2/28/18
 * function:
 * description:
 */

public class main  {

    public static void main(String[] args){
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();
        concreteAggregate.add("aaa");
        concreteAggregate.add("b");
        concreteAggregate.add("c");
        concreteAggregate.add("d");
        concreteAggregate.add("e");
        concreteAggregate.add("s");

        Iterator iterator =  concreteAggregate.CreateIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

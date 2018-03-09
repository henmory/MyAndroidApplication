package com.henmory.designpattern.design_pattern.Miterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author: henmory
 * time:  2/28/18
 * function:
 * description:
 */

public class ConcreteAggregate implements Aggragate{

    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public void remove(Object object) {
        list.remove(object);
    }

    @Override
    public Myiterator CreateIterator() {

        return new Myiterator();
    }

    private class Myiterator implements Iterator{

        private int cursor;
        @Override
        public boolean hasNext() {
            if (cursor < list.size() - 1){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (cursor < list.size() - 1){
                return list.get(cursor++);
            }else{
                return null;
            }
        }
    }
}

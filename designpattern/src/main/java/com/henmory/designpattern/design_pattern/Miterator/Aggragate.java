package com.henmory.designpattern.design_pattern.Miterator;

import java.util.Iterator;

/**
 * author: henmory
 * time:  2/28/18
 * function:
 * description:
 */

public interface Aggragate {
    void add(Object object);
    void remove(Object object);
    Iterator CreateIterator();
}

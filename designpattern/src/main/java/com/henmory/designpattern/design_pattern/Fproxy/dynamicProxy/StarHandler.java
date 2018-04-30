package com.henmory.designpattern.design_pattern.Fproxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author: henmory
 * time:  4/7/18
 * function:
 * description:
 */
public class StarHandler implements InvocationHandler {

    Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("######");
        method.invoke(realStar, args);

        return null;
    }
}

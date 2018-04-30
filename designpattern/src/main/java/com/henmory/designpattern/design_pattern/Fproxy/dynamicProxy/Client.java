package com.henmory.designpattern.design_pattern.Fproxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * author: henmory
 * time:  4/7/18
 * function:
 * description:
 */
public class Client {

    public static void main(String[] strings){

        Star realStar = new RealStar();

        StarHandler handler = new StarHandler(realStar);

        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]  {Star.class}, handler);

        proxy.sing();
    }
}

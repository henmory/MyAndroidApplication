package com.henmory.designpattern.design_pattern.Asingleton;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description: 懒汉式
 */

public class SingleTon2 {

    private static SingleTon2 singleton2 = null;

    private SingleTon2() {
    }

    //同步方法
    public static synchronized SingleTon2 getInstance(){
        if (null ==  singleton2){
            singleton2 = new SingleTon2();
        }
        return singleton2;
    }

    //同步代码段,为什么this不行，而.class可以（.this上锁为对象，class上锁对象为类，因而非静态方法为this,静态方法为class）
    //线程仍然是不安全的====有些书上说不安全，不清楚为什么
//    public static synchronized SingleTon2 getInstance(){
//
//        synchronized (SingleTon2.class){
//            if (null ==  singleton2){
//                singleton2 = new SingleTon2();
//            }
//        }
//        return singleton2;
//    }

    //synchronized(this)锁定的式当前对象
    //synchronized（）可以跟不同的对象，
    //synchronized对static方法方法加锁，式给class类上锁,如果是一般的方法，那么上锁的是对象

}

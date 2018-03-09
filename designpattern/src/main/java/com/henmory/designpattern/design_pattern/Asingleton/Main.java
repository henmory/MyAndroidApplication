package com.henmory.designpattern.design_pattern.Asingleton;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:
 */

public class Main {
    public static void main(String[] args){
//        System.out.println(SingleTon1.getInstance());
//        System.out.println(SingleTon2.getInstance());
//        System.out.println(SingleTon3.getInstance());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(SingleTon2.getInstance());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(SingleTon2.getInstance());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(SingleTon2.getInstance());
            }
        }).start();
    }
}

package com.henmory.designpattern.design_pattern.Dprototype;

import java.util.Date;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:
 */

public class main {
    public static void main(String[] args) throws CloneNotSupportedException {

//        testShallowClone();
        testDeepClone();


    }

    public static void testShallowClone() throws CloneNotSupportedException {
        Date date = new Date(1232144L);
        ShallowSheep sheep = new ShallowSheep("多利", date);

        //原对象的值
        System.out.println("原对象的值---------");
        System.out.println(sheep);
        System.out.println(sheep.getName());
        System.out.println(sheep.getBirthday());

        //克隆第二个对象
        ShallowSheep sheep1 = (ShallowSheep)sheep.clone();
        sheep1.setName("少理");

        //修改原对象的值
        date.setTime(2442255L);

        //原对象值
        System.out.println(sheep.getBirthday());

        //克隆对象的值
        System.out.println("克隆对象的值---------");
        System.out.println(sheep1);
        System.out.println(sheep1.getName());
        System.out.println(sheep1.getBirthday());
    }

    public static void testDeepClone() throws CloneNotSupportedException {

        Date date = new Date(1232144L);
        DeepSheep sheep = new DeepSheep("多利", date);

        //原对象的值
        System.out.println("原对象的值---------");
//        System.out.println(sheep);
        System.out.println(sheep.getName());
        System.out.println("原对象生日:" + sheep.getBirthday());

        //克隆第二个对象
        DeepSheep sheep1 = (DeepSheep)sheep.clone();
        sheep1.setName("少理");

        System.out.println("克隆对象的值---------");
//        System.out.println(sheep1);
        System.out.println(sheep1.getName());
        System.out.println("克隆对象生日:" + sheep1.getBirthday());


        //修改原对象的值
        date.setTime(2442444255L);

        //原对象值
        System.out.println("修改后原对象的生日为:" + sheep.getBirthday());
        //克隆对象的值
        System.out.println("修改后克隆对象生日:" + sheep1.getBirthday());
    }
}

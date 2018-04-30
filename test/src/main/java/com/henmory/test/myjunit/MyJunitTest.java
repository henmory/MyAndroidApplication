package com.henmory.test.myjunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: henmory
 * time:  4/3/18
 * function:
 * description:
 */

public class MyJunitTest {

    public static void main(String[] arg){
        //获取字节码对象
        Class clazz = MyJunitTest.class;
        //获取字节码对象上有MyJunit注解的方法

        //获取所有方法

        Method[] methods = clazz.getMethods();
        for (Method method : methods
             ) {
            //判断方法是否含有MyJunit注解
            boolean b = method.isAnnotationPresent(MyJunit.class);
            if (true == b){
                try {
                    method.invoke(clazz.newInstance(),null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @MyJunit
    public void methord(){
        System.out.println("自定义注解");
    }
}

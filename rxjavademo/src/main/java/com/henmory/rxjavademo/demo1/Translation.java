package com.henmory.rxjavademo.demo1;

/**
 * author: henmory
 * time:  4/4/18
 * function:
 * description:
 */

public class Translation {

    private int status;
    private content content;

    private static class content {
        private String from; //原文内容类型
        private String to;  //译文内容类型
        private String vendor;//来源平台
        private String out;//译文内容
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        System.out.println( "Rxjava翻译结果：" + status);
        System.out.println("Rxjava翻译结果：" + content.from);
        System.out.println("Rxjava翻译结果：" + content.to);
        System.out.println("Rxjava翻译结果：" + content.vendor);
        System.out.println("Rxjava翻译结果：" + content.out);
        System.out.println("Rxjava翻译结果：" + content.errNo);
    }


}

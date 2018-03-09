package com.henmory.designpattern.design_pattern.Hcomposite;

/**
 * author: henmory
 * time:  2/8/18
 * function:
 * description:
 */

public class Test {

    public static void main(String[] args){

        Folder folder = new Folder("工作");

        ImageFIle imageFIle = new ImageFIle("我的证件照");

        TextFile textFile = new TextFile("我的简介");


        TextFile textFile1 = new TextFile("简历");

        Folder folder1 = new Folder("移民相关");

        ImageFIle imageFIle1 = new ImageFIle("特殊照片");
        TextFile textFile2 = new TextFile("身份证明");

        folder.add(imageFIle);
        folder.add(textFile);
        folder.add(textFile1);

        folder.add(folder1);
        folder1.add(imageFIle1);
        folder1.add(textFile2);
        folder.killiVirus();
    }
}

package com.henmory.designpattern.design_pattern.Hcomposite;

/**
 * author: henmory
 * time:  2/8/18
 * function:
 * description:
 */

public class ImageFIle extends AbstractFile {
    private String name;

    public ImageFIle(String name) {
        this.name = name;
    }

    @Override
    public void killiVirus() {
        System.out.println("文件名为" + name + "杀毒");
    }
}

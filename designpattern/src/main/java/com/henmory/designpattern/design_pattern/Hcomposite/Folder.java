package com.henmory.designpattern.design_pattern.Hcomposite;

import java.util.ArrayList;
import java.util.List;

/**
 * author: henmory
 * time:  2/8/18
 * function:
 * description:
 */

public class Folder extends AbstractFile {
    private String name;
    private List<AbstractFile> list = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file){
        list.add(file);
    }

    public void remove(AbstractFile file){
        list.remove(file);
    }

    public AbstractFile getFile(int index){
        return list.get(index);
    }
    @Override
    void killiVirus() {
        System.out.println("文件夹名字为" + name + "杀毒");
        for (int i = 0; i < list.size(); i++){
            list.get(i).killiVirus();
        }
    }
}

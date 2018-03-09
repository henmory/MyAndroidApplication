package com.henmory.designpattern.design_pattern.Dprototype;

import java.util.Date;

/**
 * author: henmory
 * time:  2/27/18
 * function:
 * description:
 */

public class DeepSheep implements Cloneable{

    private String name;
    private Date birthday;

    public DeepSheep() {
    }

    public DeepSheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepSheep sheep = (DeepSheep) super.clone();
        sheep.birthday = (Date) this.birthday.clone();
        return sheep;
    }
}

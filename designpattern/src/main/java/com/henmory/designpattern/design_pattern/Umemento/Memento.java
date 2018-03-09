package com.henmory.designpattern.design_pattern.Umemento;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:备忘类
 */

public class Memento {

    private String name;
    private String age;
    private String salary;


    public Memento(Originator originator){
        this.name = originator.getName();
        this.age = originator.getAge();
        this.salary = originator.getSalary();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

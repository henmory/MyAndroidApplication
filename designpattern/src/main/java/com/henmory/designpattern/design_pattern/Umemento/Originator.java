package com.henmory.designpattern.design_pattern.Umemento;

/**
 * author: henmory
 * time:  2/26/18
 * function:
 * description:  要备忘的对象
 */

public class Originator {

    private String name;
    private String age;
    private String salary;

    //开始备忘
    public Memento memento(){

        return new Memento(this);
    }
    //开始恢复
    public void recover(Memento memento){
        this.name = memento.getName();
        this.age = memento.getAge();
        this.salary = memento.getSalary();
    }
    public Originator(String name, String age, String salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

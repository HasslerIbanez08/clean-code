package com.usercases;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public boolean runInGround(String location){
        if(location.equalsIgnoreCase("Ground")){
            System.out.println("the person run in the ".concat(location));
            return true;
        }
        System.out.println("the person doesn't run in the ".concat(location));
        return false;
    }
    public boolean isPlay(){
        if(this.runInGround("ground")){
            System.out.println("The person play");
            return true;
        }
        System.out.println("The person doesn't play");
        return  false;
    }
}

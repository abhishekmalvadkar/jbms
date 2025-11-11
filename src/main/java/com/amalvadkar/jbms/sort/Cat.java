package com.amalvadkar.jbms.sort;

import lombok.Getter;

@Getter
public class Cat implements Comparable<Cat> {
    private String name;
    private int age;
    private int weight ;

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return this.age-o.getAge();
    }
}

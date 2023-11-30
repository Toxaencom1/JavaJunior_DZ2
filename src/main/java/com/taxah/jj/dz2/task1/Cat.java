package com.taxah.jj.dz2.task1;

public class Cat extends Animal {
    boolean wild;


    public Cat(String name, int age, boolean crazy) {
        super(name, age);
        this.wild = crazy;
    }

    public void eat() {
        System.out.print("Cat is eating...");
    }

    public void play() {
        System.out.print("Cat is playing...");
    }

    public void sleep() {
        System.out.print("Cat is sleeping...");
    }
}

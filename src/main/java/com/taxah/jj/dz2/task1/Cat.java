package com.taxah.jj.dz2.task1;

public class Cat extends Animal {


    public Cat(String name, int age) {
        super(name, age);
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

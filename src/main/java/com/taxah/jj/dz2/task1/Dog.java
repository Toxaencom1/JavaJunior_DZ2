package com.taxah.jj.dz2.task1;

public class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
    }

    public void find(){
        System.out.print("Sniff sniff sniff...");
    }

    public void serve(){
        System.out.print("Dog serving...");
    }

    public void makeSound(){
        System.out.print("Woof woof...");
    }
    public void eat(){
        System.out.print("Dog is eating...");
    }
}

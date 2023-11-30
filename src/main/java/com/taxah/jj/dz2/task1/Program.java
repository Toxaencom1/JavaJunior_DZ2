package com.taxah.jj.dz2.task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
Задача 1:
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */
public class Program {

    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Cassie", 3, true),
                new Dog("Graf", 1, true),
                new Cat("Tishka", 2, false)};
        for (Animal animal : animals) {
            printInfo(animal);
        }
    }

    private static void printInfo(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("Class: " + clazz.getSimpleName());
        // Displaying information about fields
        System.out.println("Fields:");
        Class<?> superClass = clazz.getSuperclass();
        for (Field field : superClass.getDeclaredFields()) { // If the super class has fields
            try {
                field.setAccessible(true);
                System.out.println("    " + field.getName() + ": " + field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        for (Field field : clazz.getDeclaredFields()) { // If the subclass has fields
            try {
                field.setAccessible(true);
                System.out.println("    " + field.getName() + ": " + field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        // Displaying information about methods
        System.out.print("Methods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.print("\n    " + method.getName());
            if (method.getName().equals("makeSound")) {
                try {
                    System.out.print(" - invoked from task: ");
                    method.invoke(obj);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("\n=================");
    }
}

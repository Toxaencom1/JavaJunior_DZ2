package com.taxah.jj.dz2.task1;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/*
Задача 1:
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */

/**
 * The Program class demonstrates the use of Reflection API to work with the Animal hierarchy.
 * It defines an abstract class "Animal" with common fields "name" and "age". Two subclasses,
 * "Dog" and "Cat," extend the "Animal" class with unique methods. The program creates
 * an array of "Animal" objects, prints information about each object, and invokes the "makeSound"
 * method if present using Reflection.
 */
public class Program {

    private static final AnimalNames[] VALUES = AnimalNames.values();
    private static final Random random = new Random();
    private static final int SIZE = VALUES.length;

    /**
     * The main method creates instances of "Cat" and "Dog" using Reflection,
     * populates an array with these objects, and prints information about each object.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Animal cat1 = null;
        Animal dog1 = null;
        Animal dog2 = null;
        Animal cat2 = null;
        try {
            cat1 = makeObj(Cat.class);
            dog1 = makeObj(Dog.class);
            dog2 = makeObj(Dog.class);
            cat2 = makeObj(Cat.class);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }

        Animal[] animals = {cat1, dog1, dog2, cat2};
        for (Animal animal : animals) {
            printInfo(animal);
        }
    }

    /**
     * Creates an instance of the specified class extended by 'Animal' using Reflection, providing a random name and age.
     *
     * @param clazz The class for which an object is to be created.
     * @return An instance of the specified class.
     * @throws InvocationTargetException If the underlying constructor throws an exception.
     * @throws InstantiationException    If the class that declares the underlying constructor represents an abstract class.
     * @throws IllegalAccessException    If this {@code Constructor} object enforces Java language access control and the
     *                                   underlying constructor is inaccessible.
     * @throws NoSuchMethodException     If a matching method is not found.
     */
    private static Animal makeObj(Class<? extends Animal> clazz) throws InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<?>[] constructors = clazz.getConstructors();
        String name = VALUES[random.nextInt(1, SIZE)].getDisplayName();
        int age = random.nextInt(0, 7);
        return (Animal) constructors[0].newInstance(name, age);
    }

    /**
     * Prints information about the provided object, including class name, fields, and methods.
     *
     * @param obj The object for which information is to be printed.
     */
    private static void printInfo(Object obj) {
        Class<?> clazz = obj.getClass();
        Class<?> superClass = clazz.getSuperclass();
        System.out.println("Class: " + clazz.getSimpleName());
        // Displaying information about fields
        System.out.println("Fields:");
        showFieldsInfo(superClass, obj);
        showFieldsInfo(clazz, obj);
        // Displaying information about methods
        System.out.print("Methods:");
        showMethodsInfo(superClass, obj);
        showMethodsInfo(clazz, obj);
        System.out.println("\n=================");
    }

    /**
     * Displays information about fields of a given class instance.
     *
     * @param clazz The Class object representing the class.
     * @param obj   The object for which field information is to be displayed.
     */
    private static void showFieldsInfo(Class<?> clazz, Object obj) {
        for (Field f : clazz.getDeclaredFields()) {
            try {
                f.setAccessible(true);
                System.out.println("    " + f.getType().getSimpleName() + " " + f.getName() + " = " +
                        String.format(
                                (f.getType().equals(String.class)) ? ("\"" + f.get(obj) + "\";") : (f.get(obj) + ";")
                        ));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Displays information about methods of a given class instance.
     * Method will be invoked if his name "makeSound"
     * @param clazz The Class object representing the class.
     * @param obj   The object for which method information is to be displayed.
     */
    private static void showMethodsInfo(Class<?> clazz, Object obj) {
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.print("\n    " + method.getReturnType() + " " + method.getName() + "()");
            if (method.getName().equals("makeSound")) {
                try {
                    System.out.print(" - invoked because in task description, result: ");
                    method.invoke(obj);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package org.jugph.bootcamp.lessons.javaBasicFeatures.oop.inheritance;

public class SuperclassAnimal {
    protected String name;

    public SuperclassAnimal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

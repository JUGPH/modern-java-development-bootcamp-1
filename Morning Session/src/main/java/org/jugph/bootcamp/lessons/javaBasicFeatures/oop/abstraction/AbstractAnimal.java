package org.jugph.bootcamp.lessons.javaBasicFeatures.oop.abstraction;

// Abstract class
abstract class AbstractAnimal {
    // Abstract method (does not have a body)
    public abstract void makeSound();

    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

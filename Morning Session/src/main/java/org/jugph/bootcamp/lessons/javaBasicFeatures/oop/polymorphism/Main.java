package org.jugph.bootcamp.lessons.javaBasicFeatures.oop.polymorphism;

public class Main {
    public static void main(String[] args) {
        SuperclassAnimal myAnimal = new SuperclassAnimal(); // Animal reference and object
        SuperclassAnimal myDog = new SubclassDog();       // Animal reference but Dog object

        myAnimal.makeSound(); // Calls Animal's makeSound
        myDog.makeSound();    // Calls Dog's makeSound (polymorphism)
    }
}


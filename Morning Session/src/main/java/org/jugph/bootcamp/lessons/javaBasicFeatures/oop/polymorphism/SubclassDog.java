package org.jugph.bootcamp.lessons.javaBasicFeatures.oop.polymorphism;

public class SubclassDog extends SuperclassAnimal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks");
    }
}

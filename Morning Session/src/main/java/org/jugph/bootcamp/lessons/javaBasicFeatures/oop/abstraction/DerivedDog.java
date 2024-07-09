package org.jugph.bootcamp.lessons.javaBasicFeatures.oop.abstraction;

// Dog class extends Animal
class DerivedDog extends AbstractAnimal {
    // Implementation of abstract method
    public void makeSound() {
        System.out.println("Bark bark");
    }
}


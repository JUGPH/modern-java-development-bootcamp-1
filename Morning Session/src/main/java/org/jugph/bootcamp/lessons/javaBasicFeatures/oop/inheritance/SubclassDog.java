package org.jugph.bootcamp.lessons.javaBasicFeatures.oop.inheritance;

public class SubclassDog extends SuperclassAnimal {

    public SubclassDog(String name) {
        super(name); // Call the constructor of the superclass (Animal)
    }

    // Additional method specific to Dog
    public void bark() {
        System.out.println(name + " is barking.");
    }
}


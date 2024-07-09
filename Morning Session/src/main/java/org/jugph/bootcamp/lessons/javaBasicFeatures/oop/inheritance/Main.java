package org.jugph.bootcamp.lessons.javaBasicFeatures.oop.inheritance;

public class Main {
    public static void main(String[] args) {
        SubclassDog myDog = new SubclassDog("Buddy");

        // Calling methods from the Animal class
        myDog.eat();
        myDog.sleep();

        // Calling method from the Dog class
        myDog.bark();
    }
}

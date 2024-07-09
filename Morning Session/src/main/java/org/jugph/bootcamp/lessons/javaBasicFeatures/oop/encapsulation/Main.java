package org.jugph.bootcamp.lessons.javaBasicFeatures.oop.encapsulation;

public class Main {
    public static void main(String[] args) {
        Encapsulation person = new Encapsulation();
        person.setName("Martin");
        person.setAge(25);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}

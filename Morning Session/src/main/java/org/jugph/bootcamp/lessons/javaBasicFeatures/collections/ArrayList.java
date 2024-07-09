package org.jugph.bootcamp.lessons.javaBasicFeatures.collections;

import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        // Creating an ArrayList
        List<String> names = new java.util.ArrayList<>();

        // Adding elements
        names.add("Drogon");
        names.add("Rhaegal");
        names.add("Viserion");

        // Iterating through elements
        for (String name : names) {
            System.out.println(name);
        }

        // Getting element by index
        System.out.println("First name: " + names.get(0));

        // Removing element
        names.remove("Rhaegal");
        System.out.println("After removal: " + names);
    }
}


package org.jugph.bootcamp.lessons.java8.optional;

import java.util.Optional;

public class User {
    private String name;
    private Optional<String> email;

    // Constructor
    public User(String name, Optional<String> email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }
}

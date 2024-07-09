package org.jugph.bootcamp.lessons.java8.optional;

import java.util.Optional;

public class OptionalFeat {
    public static void main(String[] args) {
        // Create a User with an email
        User userWithEmail = new User("Daenerys", Optional.of("Daenerys@example.com"));

        // Create a User without an email
        User userWithoutEmail = new User("Jon", null);

        // Print user information
        printUserInfo(userWithEmail);
        printUserInfo(userWithoutEmail);
    }

    public static void printUserInfo(User user) {
        System.out.println("Name: " + user.getName());

        // Using orElse to provide a default message if email is not present
        String email = user.getEmail().orElse("Email not provided");
        System.out.println("Email: " + email);
    }
}

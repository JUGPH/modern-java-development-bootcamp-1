package org.jugph.bootcamp.records.records;

import java.time.LocalDate;

public record User(String username,
                   String email,
                   LocalDate birthdate) {
    public User {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (birthdate == null || birthdate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birthdate cannot be null or in the future");
        }
    }
}
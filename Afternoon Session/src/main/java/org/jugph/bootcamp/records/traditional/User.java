package org.jugph.bootcamp.records.traditional;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public final class User {

    private final String username;
    private final String email;
    private final LocalDate birthDate;

    public User(String username, String email, LocalDate birthDate) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birthdate cannot be null or in the future");
        }
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean isAdult() {
        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, birthDate);
    }
}

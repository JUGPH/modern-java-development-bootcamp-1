package org.jugph.bootcamp.records.traditional.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class User {

    private final String username;
    private final String email;
    private final LocalDate birthDate;

    public boolean isAdult() {
        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }
}
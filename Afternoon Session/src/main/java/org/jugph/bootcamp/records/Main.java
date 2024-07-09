package org.jugph.bootcamp.records;


import org.jugph.bootcamp.records.records.User;

import java.time.LocalDate;

public class Main {
    void main() {
        var myUserRecord = new User("username", "sample@example.com",
                LocalDate.now());

        System.out.println(myUserRecord);
        System.out.println(myUserRecord.equals(new User("username", "sample@example.com",
                LocalDate.now())));
        System.out.println(myUserRecord.hashCode());
        System.out.println(myUserRecord.email() + " " + myUserRecord.username() +
                myUserRecord.birthdate());

        var user2 = new User(null, null, null);

    }
}

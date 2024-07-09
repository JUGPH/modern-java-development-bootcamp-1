package org.jugph.bootcamp.lessons.java12;

public class NewSwitchExample {

    public static void main(String[] args) {
        String day = "Monday";

        String typeOfDay = switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };

        System.out.println(day + " is a " + typeOfDay);
    }
}

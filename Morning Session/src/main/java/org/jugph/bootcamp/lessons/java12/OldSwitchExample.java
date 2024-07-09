package org.jugph.bootcamp.lessons.java12;

public class OldSwitchExample {

    public static void main(String[] args) {
        String day = "Monday";
        String typeOfDay;

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                typeOfDay = "Weekday";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }

        System.out.println(day + " is a " + typeOfDay);
    }
}

package org.jugph.bootcamp.activity.javaActivity1;

public class Student {
    public String name;
    public String age;
    public String grade;

    @Override
    public String toString() {
        return String.format("%s,%s,%s", name, age, grade);
    }
}
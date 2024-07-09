package org.jugph.bootcamp.activity.javaActivity1.modified;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StudentRegistration2 {
    public static void main(String[] args) {
        var registration = new StudentRegistration2();
        registration.registerStudents();
    }

    public void registerStudents() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        var numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        var studentList = new ArrayList<Map<String, String>>();
        for (var i = 0; i < numberOfStudents; i++) {
            var student = new HashMap<String, String>();
            System.out.println("Enter name: ");
            student.put("name", scanner.nextLine());
            System.out.println("Enter age: ");
            student.put("age", scanner.nextLine());
            System.out.println("Enter grade: ");
            student.put("grade", scanner.nextLine());
            studentList.add(student);
        }

        writeStudentsToFile(studentList);
        var readList = readStudentsFromFile();
        for (var student : readList) {
            if (!isGradeCOrLower(student)) {
                System.out.println("Student: " + student);
            }
        }
    }

    public boolean isGradeCOrLower(Map<String, String> student) {
        var grade = student.get("grade");
        return switch (grade) {
            case "A", "B" -> false;
            case "C" -> true;
            default -> true;
        };
    }

    public void writeStudentsToFile(List<Map<String, String>> studentList) {
        var stringBuilder = new StringBuilder();
        for (var student : studentList) {
            stringBuilder.append(student.get("name"))
                    .append(",")
                    .append(student.get("age"))
                    .append(",")
                    .append(student.get("grade"))
                    .append("\n");
        }
        try {
            Files.writeString(Paths.get("students.txt"), stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, String>> readStudentsFromFile() {
        var studentList = new ArrayList<Map<String, String>>();
        try {
            var lines = Files.readString(Paths.get("students.txt")).split("\n");
            for (var line : lines) {
                var parts = line.split(",");
                var student = new HashMap<String, String>();
                student.put("name", parts[0]);
                student.put("age", parts[1]);
                student.put("grade", parts[2]);
                studentList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}

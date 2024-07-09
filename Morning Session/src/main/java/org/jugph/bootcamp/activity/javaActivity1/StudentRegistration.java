package org.jugph.bootcamp.activity.javaActivity1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StudentRegistration {
    public static void main(String[] args) {
        new StudentRegistration().registerStudents();
    }

    public void registerStudents() {
        var studentList = enterStudentInfo();
        writeStudentInfo(studentList);
        displayStudentIfo();
    }

    String askInfo(Scanner sc, String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    private List<Student> enterStudentInfo() {
        var sc = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        var n = sc.nextInt();
        sc.nextLine();

        List<Student> info = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student student1 = new Student();
            student1.name = askInfo(sc, "Enter name: ");
            student1.age = askInfo(sc, "Enter age: ");
            student1.grade = askInfo(sc, "Enter grade: ");
            info.add(student1);
        }
        return info;
    }

    private void displayStudentIfo() {
        readFile().stream().filter(student -> !isPassingGrade(student))
                .map(student -> "Student: " + student)
                .forEach(System.out::println);
    }

    public boolean isPassingGrade(Map<String, String> studentInfo) {
        return switch (studentInfo.get("grade")) {
            case "A", "B" -> false;
            default -> true;
        };
    }

    public void writeStudentInfo(List<Student> studentList) {
        var sb = new StringBuilder();
        for (Student student : studentList) sb.append(student.toString()).append("\n");
        try {
            Files.writeString(Paths.get("students.txt"), sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Map<String, String>> readFile() {
        var students = new ArrayList<Map<String, String>>();
        try {
            var ls = Files.readString(Paths.get("students.txt")).split("\n");
            for (var l : ls) {
                var studentInfo = l.split(",");
                var st = new HashMap<String, String>();
                st.put("name", studentInfo[0]);
                st.put("age", studentInfo[1]);
                st.put("grade", studentInfo[2]);
                students.add(st);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}

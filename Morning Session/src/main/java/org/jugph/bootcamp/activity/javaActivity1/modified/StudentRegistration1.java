package org.jugph.bootcamp.activity.javaActivity1.modified;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentRegistration1 {
    public static void main(String[] args) {
       new StudentRegistration1().registerStudents();
    }

    public void registerStudents() {
        var numberOfStudents = getNumberOfStudents();
        var studentsList = getStudentInfo(numberOfStudents);
        createFileOf(studentsList);
        writePassingStudents();
    }

    private void writePassingStudents() {
        readStudentsFromFile().stream().filter(student -> !checkPassing(student)).map(student -> "Student: " + student)
                .forEach(System.out::println);
    }

    private static ArrayList<Map<String, String>> getStudentInfo(int numberOfStudents) {
        var scanner = new Scanner(System.in);
        var studentsList = new ArrayList<Map<String, String>>();
        IntStream.range(0, numberOfStudents).mapToObj(i -> new HashMap<String, String>()).forEach(studentHash -> {
            askInformationOf("name", studentHash, scanner);
            askInformationOf("age", studentHash, scanner);
            askInformationOf("grade", studentHash, scanner);
            studentsList.add(studentHash);
        });
        return studentsList;
    }

    private static int getNumberOfStudents() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        var numberOfStudents = scanner.nextInt();
        scanner.nextLine();
        return numberOfStudents;
    }

    private static void askInformationOf(String inputType, HashMap<String, String> studentHash, Scanner scanner) {
        System.out.println("Enter "+inputType+": ");
        studentHash.put(inputType, scanner.nextLine());
    }

    public boolean checkPassing(Map<String, String> st) {
        var g = st.get("grade");
        return switch (g) {
            case "A", "B" -> false;
            default -> true;
        };
    }

    public void createFileOf(List<Map<String, String>> sl) {
        String stringBuilder = sl.stream().map(st -> st.get("name") + "," + st.get("age") + "," + st.get("grade") +
                        "\n").collect(Collectors.joining());
        try {
            Files.writeString(Paths.get("students.txt"), stringBuilder);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Map<String, String>> readStudentsFromFile() {
        try {
            return getStudentPerLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    private static ArrayList<Map<String, String>> getStudentPerLine() throws IOException {
        var studentWithGradeAAndB = new ArrayList<Map<String, String>>();
        var dataPerLine = Files.readString(Paths.get("students.txt")).split("\n");
        Arrays.stream(dataPerLine).map(l -> l.split(",")).forEach(p -> {
            var student = new HashMap<String, String>();
            student.put("name", p[0]);
            student.put("age", p[1]);
            student.put("grade", p[2]);
            studentWithGradeAAndB.add(student);
        });
        return studentWithGradeAAndB;
    }

    public static class BadCodeStudentRegistration2 {
        public static void main(String[] args) {
            new BadCodeStudentRegistration2().registerStudents();
        }

        public void registerStudents() {
            var sc = new Scanner(System.in);
            System.out.println("Enter number of students: ");
            var n = sc.nextInt();
            sc.nextLine(); // consume newline

            var studentsList = new ArrayList<Map<String, String>>();
            IntStream.range(0, n).mapToObj(i -> new HashMap<String, String>()).forEach(st -> {
                askStudentInfoOf("name", st, sc);
                askStudentInfoOf("age", st, sc);
                askStudentInfoOf("grade", st, sc);
                studentsList.add(st);
            });

            createStudentFile(studentsList);
            var rl = rrs();
            for (var st : rl) {
                if (!np(st)) {
                    System.out.println("Student: " + st);
                }
            }
        }

        private static void askStudentInfoOf(String infoType, HashMap<String, String> st, Scanner sc) {
            System.out.println("Enter "+infoType+": ");
            st.put(infoType, sc.nextLine());
        }

        public boolean np(Map<String, String> st) {
            var g = st.get("grade");
            return switch (g) {
                case "A", "B" -> false;
                default -> true;
            };
        }

        public void createStudentFile(List<Map<String, String>> sl) {
            var sb = new StringBuilder();
            writeEachStudentInfo(sl, sb);
            try {
                Files.writeString(Paths.get("students.txt"), sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void writeEachStudentInfo(List<Map<String, String>> sl, StringBuilder sb) {
            for (Map<String, String> st : sl) {
                sb.append(st.get("name")).append(",").append(st.get("age")).append(",").append(st.get("grade")).append("\n");
            }
        }

        public List<Map<String, String>> rrs() {
            var rl = new ArrayList<Map<String, String>>();
            try {
                var ls = Files.readString(Paths.get("students.txt")).split("\n");
                for (var l : ls) {
                    var p = l.split(",");
                    var st = new HashMap<String, String>();
                    st.put("name", p[0]);
                    st.put("age", p[1]);
                    st.put("grade", p[2]);
                    rl.add(st);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return rl;
        }
    }
}

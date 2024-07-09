package org.jugph.bootcamp.lessons.javaBasicFeatures;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("************************************");
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                System.out.println("******Welcome to our training!******");
            } else {
                System.out.println("************************************");
            }
        }
        System.out.println("************************************");
        System.out.println("Hello, " + name + "! We're glad to have you here.");
        scanner.close();
    }
}


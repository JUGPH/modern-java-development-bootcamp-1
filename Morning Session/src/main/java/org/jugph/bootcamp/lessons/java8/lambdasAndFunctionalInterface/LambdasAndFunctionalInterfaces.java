package org.jugph.bootcamp.lessons.java8.lambdasAndFunctionalInterface;

// Functional Interface
interface MathOperation {
    int operate(int a, int b);
}

public class LambdasAndFunctionalInterfaces {
    public static void main(String[] args) {
        // Lambda expression to implement addition
        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        // Lambda expression to implement subtraction
        MathOperation subtraction = (a, b) -> a - b;

        // Using the functional interfaces with lambdas
        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 - 5 = " + operate(10, 5, subtraction));
    }

    // Method that accepts a functional interface as a parameter
    public static int operate(int a, int b, MathOperation operation) {
        return operation.operate(a, b);
    }
}

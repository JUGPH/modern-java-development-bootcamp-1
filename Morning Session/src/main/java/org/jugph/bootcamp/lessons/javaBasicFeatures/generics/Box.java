package org.jugph.bootcamp.lessons.javaBasicFeatures.generics;

// Generic class Box
public class Box<T> {
    private T content;

    // Constructor
    public Box(T content) {
        this.content = content;
    }

    // Getter and setter for content
    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    // Example method using generics
    public void displayBoxContent() {
        System.out.println("Box contains: " + content);
    }

    public static void main(String[] args) {
        // Create a Box of Integer
        Box<Integer> integerBox = new Box<>(123);
        integerBox.displayBoxContent();

        // Create a Box of String
        Box<String> stringBox = new Box<>("Hello, Generics!");
        stringBox.displayBoxContent();
    }
}


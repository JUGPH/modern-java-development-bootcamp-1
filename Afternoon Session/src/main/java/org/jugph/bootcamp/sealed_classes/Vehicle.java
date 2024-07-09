package org.jugph.bootcamp.sealed_classes;

public sealed class Vehicle implements Driveable permits Train, Boat, MotorVehicle {

    /**
     * Your Task
     * Create a new sealed class: Add a new sealed class called MotorVehicle to the
     * existing Vehicle hierarchy. The MotorVehicle class should permit only Car and a new subclass
     * called Motorcycle.
     *
     * Create a new subclass: Add a new subclass called Motorcycle that extends MotorVehicle.
     * The Motorcycle class should be a final class and not be extendable.
     *
     * Override methods: Implement the move method for the Motorcycle class.
     */

    public void move() {
        System.out.println("Vehicle move");
    }
}

package org.jugph.bootcamp.sealed_classes;

public sealed class MotorVehicle extends Vehicle permits Car, Motorcycle  {

    @Override
    public void move() {
        System.out.println("MotorVehicle move");
    }
}

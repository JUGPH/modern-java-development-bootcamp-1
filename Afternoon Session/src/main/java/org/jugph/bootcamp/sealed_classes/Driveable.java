package org.jugph.bootcamp.sealed_classes;

public sealed interface Driveable permits Vehicle {

    void move();
}
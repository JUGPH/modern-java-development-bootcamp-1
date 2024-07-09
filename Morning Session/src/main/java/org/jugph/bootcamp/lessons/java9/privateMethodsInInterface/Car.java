package org.jugph.bootcamp.lessons.java9.privateMethodsInInterface;

interface Vehicle {
    // Default method to calculate fuel consumption in gallons
    static double calculateFuelConsumption(double distance, double fuelUsed) {
        return distance / fuelUsed;
    }

    // Default method to calculate fuel consumption in liters
    static double calculateFuelConsumptionInLiters(double distance, double fuelUsed) {
        return removeDecimals(calculateFuelConsumption(distance, fuelUsed) * 3.78541); // 1 gallon = 3.78541 liters
    }

    // Private method to remove decimals
    static double removeDecimals(double fuelConsumption) {
        return (int)fuelConsumption;
    }
}

class Car implements Vehicle {
    public static void main(String[] args) {
        printFuelConsumption(12, 23);
    }

    public static void printFuelConsumption(double distance, double fuelUsed) {
        double consumptionInGallons = Vehicle.calculateFuelConsumption(distance, fuelUsed);
        double consumptionInLiters = Vehicle.calculateFuelConsumptionInLiters(distance, fuelUsed);

        System.out.println("Fuel consumption in gallons: " + consumptionInGallons);
        System.out.println("Fuel consumption in liters: " + consumptionInLiters);
    }
}

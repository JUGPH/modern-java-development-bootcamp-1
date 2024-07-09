package org.jugph.bootcamp.lessons.java8.streamApi;

import java.util.ArrayList;
import java.util.List;

public class CarExample {

    public static void main(String[] args) {
        List<String> carNames = new ArrayList<>();
        carNames.add("Honda Civic");
        carNames.add("Toyota Camry");
        carNames.add("Ford Mustang");
        carNames.add("Tesla Model S");

        List<String> carNamesWithT = new ArrayList<>();

        for(String carName : carNames){
            if (carName.toUpperCase().charAt(0) == 'T') {
                carNamesWithT.add(carName.toUpperCase());
            }
        }

        carNamesWithT = carNames.stream().filter(carName -> carName.startsWith("T"))
                    .map(String::toUpperCase).toList();

        // Print all car names
        System.out.println("Car names before Stream operations:");
        for (String name : carNamesWithT) {
            System.out.println(name);
        }
    }
}

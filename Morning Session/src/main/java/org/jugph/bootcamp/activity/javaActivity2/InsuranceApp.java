package org.jugph.bootcamp.activity.javaActivity2;

import java.util.*;

interface InsurancePolicy {
    static List<String> createPolicyTypes() {
        return Arrays.asList("Health", "Car", "Home");
    }

    default void processPolicy(String type) {
        System.out.println("Processing policy type: " + type);
    }
}

public class InsuranceApp {
    public static void main(String[] args) {
        Set<String> customers = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie"));
        Optional<String> optionalType = Optional.of("Health");
        optionalType.ifPresent(s -> System.out.println("Found optional typeOfInsurance: " + s));

        customers.stream().map(customer -> "Processing customer: " + customer).forEach(System.out::println);

        for (String s : InsurancePolicy.createPolicyTypes()) {
            InsurancePolicy policy = new InsurancePolicy() {
                @Override
                public void processPolicy(String type) {
                    System.out.println("Processing policy typeOfInsurance: " + type);
                }
            };
            policy.processPolicy(s);
        }
    }
}


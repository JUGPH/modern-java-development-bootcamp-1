package org.jugph.bootcamp.activity.javaActivity2.Modified;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

interface InsurancePolicy {
    void processPolicy(String type);

    static List<String> createPolicyTypes() {
        return Arrays.asList("Health", "Car", "Home");
    }
}

public class InsuranceApp {
    public static void main(String[] args) {
        String optionalInsurance = "Health";
        printOptionalInsurance(optionalInsurance);

        processCustomer();

        processPolicy();
    }

    private static void processPolicy() {
        InsurancePolicy.createPolicyTypes().forEach(type -> {
            InsurancePolicy policy = t -> System.out.println("Processing policy typeOfInsurance: " + t);
            policy.processPolicy(type);
        });
    }

    private static void processCustomer() {
        Set.of("Alice", "Bob", "Charlie").forEach(customer -> System.out.println("Processing customer: " + customer));
    }

    private static void printOptionalInsurance(String optionalInsurance) {
        if(!optionalInsurance.isEmpty()){
            System.out.println("Found optional typeOfInsurance: " + optionalInsurance);
        }
    }
}


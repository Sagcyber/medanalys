package com.medcenter.app;

import com.medcenter.exceptions.InvalidComplaintException;
import com.medcenter.models.Patient;
import com.medcenter.models.Test;
import com.medcenter.services.AnalysisSelector;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                throw new InvalidComplaintException("Name cannot be empty!");
            }

            System.out.print("Enter your age: ");
            int age;
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    throw new InvalidComplaintException("Age must be a positive number!");
                }
            } catch (NumberFormatException e) {
                throw new InvalidComplaintException("Age must be a valid number!");
            }

            System.out.print("Enter your complaints (comma separated): ");
            List<String> complaintList = Arrays.asList(scanner.nextLine().split(",\\s*"));

            complaintList = complaintList.stream()
                                         .map(String::trim)
                                         .filter(s -> !s.isEmpty())
                                         .collect(Collectors.toList());

            if (complaintList.isEmpty()) {
                throw new InvalidComplaintException("Complaints cannot be empty!");
            }

            Patient patient = new Patient(name, age, complaintList);

            AnalysisSelector selector = new AnalysisSelector();
            Set<Test> recommendedTests = selector.selectTests(patient);

            System.out.println("Recommended tests for " + patient.getName() + ":");
            for (Test test : recommendedTests) {
                System.out.println("- " + test.getName() + ": " + test.getDescription());
            }

        } catch (InvalidComplaintException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

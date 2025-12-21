package com.medcenter.app;

import com.medcenter.exceptions.InvalidComplaintException;
import com.medcenter.models.Patient;
import com.medcenter.models.Test;
import com.medcenter.services.AnalysisSelector;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Main class for MedAnalys application.
 * Handles user input for patients and outputs recommended tests based on complaints.
 */
public class Main {

    /**
     * Entry point of the MedAnalys application.
     * <p>
     * Reads patient information from the console, adds patients to a list,
     * and prints recommended tests for each patient.
     * Users can enter multiple patients one by one.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        String answer;
        // try-with-resources ensures scanner is closed automatically
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    // Read patient's name
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    // Validate name is not empty
                    if (name.trim()
                            .isEmpty()) {
                        throw new InvalidComplaintException("Name cannot be empty!");
                    }
                    // Read patient's age and validate
                    System.out.print("Enter your age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    if (age <= 0) {
                        throw new InvalidComplaintException("Age must be a positive number!");
                    }
                    // Read complaints and clean list
                    System.out.print("Enter your complaints (comma separated): ");
                    List<String> complaintList = Arrays.asList(scanner.nextLine()
                                                                      .split(",\\s*"));
                    complaintList = complaintList.stream()
                                                 .map(String::trim)
                                                 .filter(s -> !s.isEmpty())
                                                 .collect(Collectors.toList());

                    if (complaintList.isEmpty()) {
                        throw new InvalidComplaintException("Complaints cannot be empty!");
                    }
                    // Create patient object and add to list
                    Patient patient = new Patient(name, age, complaintList);
                    patients.add(patient);

                } catch (InvalidComplaintException | NumberFormatException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                // Ask if user wants to add another patient
                System.out.print("Do you want to add another patient? (yes/no): ");
                answer = scanner.nextLine()
                                .trim();

            } while (answer.equalsIgnoreCase("yes"));
        }
        // Analyze all patients and print recommended tests
        AnalysisSelector selector = new AnalysisSelector();
        for (Patient p : patients) {
            Set<Test> recommendedTests = selector.selectTests(p);
            System.out.println("Recommended tests for " + p.getName() + ":");
            for (Test test : recommendedTests) {
                System.out.println("- " + test.getName() + ": " + test.getDescription());
            }
        }
    }
}

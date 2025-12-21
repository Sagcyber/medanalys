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
        
        List<Patient> patients = new ArrayList<>();
        String answer;

        do {
            try {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                if (name.trim()
                        .isEmpty()) {
                    throw new InvalidComplaintException("Name cannot be empty!");
                }

                System.out.print("Enter your age: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    throw new InvalidComplaintException("Age must be a positive number!");
                }

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

                // Создаём пациента и добавляем в список
                Patient patient = new Patient(name, age, complaintList);
                patients.add(patient);

            } catch (InvalidComplaintException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
                continue; // возвращаемся к началу цикла для нового ввода
            }

            System.out.print("Do you want to add another patient? (yes/no): ");
            answer = scanner.nextLine()
                            .trim();

        } while (answer.equalsIgnoreCase("yes"));

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

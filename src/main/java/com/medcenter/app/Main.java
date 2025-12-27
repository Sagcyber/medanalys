package com.medcenter.app;

import com.medcenter.enums.Complaint;
import com.medcenter.exceptions.MedAnalysException;
import com.medcenter.models.Patient;
import com.medcenter.models.Test;
import com.medcenter.services.AnalysisSelectorImpl;
import com.medcenter.services.PatientService;

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
        
        PatientService patientService = new PatientService();
        
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter your age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    
                    System.out.print("Enter your complaints (comma separated): ");
                    List<String> rawComplaints = Arrays.stream(scanner.nextLine().split(","))
                                                       .map(String::trim)
                                                       .filter(s -> !s.isEmpty())
                                                       .toList();
                    
                    Patient patient = patientService.createPatient(name, age, rawComplaints);
                    patients.add(patient);
                    
                } catch (MedAnalysException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Error: Age must be a number");
                }
                
                System.out.print("Do you want to add another patient? (yes/no): ");
                answer = scanner.nextLine().trim();
                
            } while (answer.equalsIgnoreCase("yes"));
        }
        
        for (Patient p : patients) {
            System.out.println("Recommended tests for " + p.getName() + ":");
            patientService.analyzePatient(p)
                          .forEach(test ->
                                           System.out.println("- " + test.getName() + ": " + test.getDescription())
                          );
        }
    }
}

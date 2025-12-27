package com.medcenter.app;

import com.medcenter.enums.Complaint;
import com.medcenter.exceptions.MedAnalysException;
import com.medcenter.models.Patient;
import com.medcenter.models.Test;
import com.medcenter.services.AnalysisSelector;
import com.medcenter.services.AnalysisSelectorImpl;
import com.medcenter.services.PatientService;
import dto.PatientRequest;
import dto.PatientResponse;

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
        
        AnalysisSelector analysisSelector = new AnalysisSelectorImpl();
        PatientService patientService = new PatientService(analysisSelector);
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter your complaints (comma separated): ");
            String rawComplaints = scanner.nextLine();
            
            PatientRequest request =
                    new PatientRequest(name, age, rawComplaints);
            
            PatientResponse response =
                    patientService.getPatientAnalysis(request);
            
            System.out.println("Recommended tests for " + response.getName() + ":");
            
            response.getRecommendedTests().forEach(test ->
                                                           System.out.println("- " + test.getName() + ": " + test.getDescription())
            );
            
        } catch (MedAnalysException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Age must be a number");
        }
    }
}


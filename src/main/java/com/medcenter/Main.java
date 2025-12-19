package com.medcenter;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Patient patient = new Patient("Anna", 30, Arrays.asList("hairloss"));

        AnalysisSelector selector = new AnalysisSelector();

        List<Test> recommendedTests = selector.selectTests(patient);

        System.out.println("Recommended tests for " + patient.getName() + ":");
        for (Test test : recommendedTests) {
            System.out.println("- " + test.getName() + ": " + test.getDescription());
        }
    }
}

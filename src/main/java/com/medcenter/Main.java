package com.medcenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<String> complainList = new ArrayList<>();
        complainList.add("headache");
        complainList.add("fatigue");

        Patient patient = new Patient("Anna", 30, complainList);

        AnalysisSelector selector = new AnalysisSelector();

        Set<Test> recommendedTests = selector.selectTests(patient);

        System.out.println("Recommended tests for " + patient.getName() + ":");
        for (Test test : recommendedTests) {
            System.out.println("- " + test.getName() + ": " + test.getDescription());
        }
    }
}

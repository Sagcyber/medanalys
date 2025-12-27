package com.medcenter.services;

import com.medcenter.enums.Complaint;
import com.medcenter.models.Patient;
import com.medcenter.models.Test;

import java.util.List;
import java.util.Set;

public class PatientService {
    
    private final AnalysisSelector analysisSelector;
    
    public PatientService(AnalysisSelector analysisSelector) {
        this.analysisSelector = analysisSelector;
    }
    
    public Patient createPatient(String name, int age, List<String> rawComplaints) {
        List<Complaint> complaints = rawComplaints.stream()
                                                  .map(Complaint::fromUserInput)
                                                  .toList();
        
        return new Patient(name, age, complaints);
    }
    
    public Set<Test> analyzePatient(Patient patient) {
        return analysisSelector.selectTests(patient);
    }
}

package com.medcenter.services;

import com.medcenter.enums.Complaint;
import com.medcenter.models.Patient;
import com.medcenter.models.Test;
import dto.PatientRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PatientService {
    
    private final AnalysisSelector analysisSelector;
    
    public PatientService(AnalysisSelector analysisSelector) {
        this.analysisSelector = analysisSelector;
    }
    
    public Patient createPatient(PatientRequest request) {
        
        List<Complaint> complaints = Arrays.stream(request.getComplaints().split(","))
                                           .map(String::trim)
                                           .filter(s -> !s.isEmpty())
                                           .map(Complaint::fromUserInput)
                                           .toList();
        
        return new Patient(
                request.getName(),
                request.getAge(),
                complaints
        );
    }
    
    public Set<Test> analyzePatient(Patient patient) {
        return analysisSelector.selectTests(patient);
    }
}

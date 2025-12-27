package com.medcenter.services;

import com.medcenter.enums.Complaint;
import com.medcenter.models.Patient;
import com.medcenter.models.Test;
import dto.PatientRequest;
import dto.PatientResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PatientService {
    
    private final AnalysisSelector analysisSelector;
    
    public PatientService(AnalysisSelector analysisSelector) {
        this.analysisSelector = analysisSelector;
    }
    
    public PatientResponse getPatientAnalysis(PatientRequest request) {
        
        List<Complaint> complaints = Arrays.stream(request.getComplaints().split(","))
                                           .map(String::trim)
                                           .filter(s -> !s.isEmpty())
                                           .map(Complaint::fromUserInput)
                                           .toList();
        
        Patient patient = new Patient(
                request.getName(),
                request.getAge(),
                complaints
        );
        
        Set<Test> tests = analysisSelector.selectTests(patient);
        
        return new PatientResponse(patient.getName(), tests);
    }
}

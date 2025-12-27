package com.medcenter.services;

import com.medcenter.models.Patient;
import com.medcenter.models.Test;

import java.util.Set;

public interface AnalysisSelector {
    
    Set<Test> selectTests(Patient patient);
    

}

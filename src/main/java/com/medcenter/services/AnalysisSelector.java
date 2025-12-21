package com.medcenter.services;

import com.medcenter.models.Patient;
import com.medcenter.models.Test;

import java.util.*;
/**
 * Service class to select recommended tests for patients based on their complaints.
 */
public class AnalysisSelector {

    private Map<String, List<Test>> testByComplaint;
    /**
     * Initializes the mapping between complaints and corresponding tests.
     */
    public AnalysisSelector() {
        testByComplaint = new HashMap<>();

        testByComplaint.put("hairloss", Arrays.asList(
                new Test("Ferritin","Ferritin level in the blood"),
                new Test("TSH","Thyroid Stimulating Hormone")
        ));

        testByComplaint.put("fatigue", Arrays.asList(
                new Test("CBC","Complete blood count"),
                new Test("Vitamin D","Vitamin D level")
        ));

        testByComplaint.put("headache", Arrays.asList(
                new Test("CBC","Complete blood count"),
                new Test("Brain MRI","MRI of the head")
        ));
    }
    /**
     * Selects a set of recommended tests for the given patient based on their complaints.
     *
     * @param patient the patient whose complaints will be analyzed
     * @return a set of recommended tests
     */
    public Set<Test> selectTests(Patient patient) {

        if (patient == null
                || patient.getComplaints() == null
                || patient.getComplaints().isEmpty()) {
            return new LinkedHashSet<>();
        }

        Set<Test> testSet = new LinkedHashSet<>();

        for (String complaint : patient.getComplaints()) {
            testSet.addAll(testByComplaint.getOrDefault(complaint, new ArrayList<>()));
        }
        return testSet;
    }
}

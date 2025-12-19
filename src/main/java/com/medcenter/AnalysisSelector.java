package com.medcenter;

import java.util.*;

public class AnalysisSelector {

    private Map<String, List<Test>> testByComplaint;

    public AnalysisSelector() {
        testByComplaint = new HashMap<>();

        testByComplaint.put("hairloss", Arrays.asList(
                new Test("Ferritin","Ferritin level in the blood"),
                new Test("TSH","Thyroid hormone")
        ));

        testByComplaint.put("fatigue", Arrays.asList(
                new Test("CBC","Complete blood count"),
                new Test("Vitamin D","Vitamin D level")
        ));
    }

    public List<Test> selectTests(Patient patient) {
        String complaint = patient.getComplains().get(0);
        return testByComplaint.getOrDefault(complaint, new ArrayList<>());
    }

}

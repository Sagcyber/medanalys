package com.medcenter;

import java.util.*;

public class AnalysisSelector {

    private Map<String, List<Test>> testByComplaint;

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
    }

    public List<Test> selectTests(Patient patient) {
        List<Test> testList = new ArrayList<>();
        for (String complaint : patient.getComplains()) {
            testList.addAll(testByComplaint.getOrDefault(complaint, new ArrayList<>()));
        }
        return testList;
    }
}

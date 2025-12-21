package com.medcenter.models;

import java.util.List;
/**
 * Represents a patient with name, age, and list of complaints.
 */
public class Patient {

    private String name;
    private int age;
    private List<String> complaints;

    /**
     * Constructor to create a Patient object.
     *
     * @param name       the patient's name
     * @param age        the patient's age
     * @param complaints list of complaints of the patient
     */
    public Patient(String name, int age, List<String> complaints) {
        this.name = name;
        this.age = age;
        this.complaints = complaints;
    }
    /**
     * @return the patient's name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the patient's age
     */
    public int getAge() {
        return age;
    }
    /**
     * @return list of patient's complaints
     */
    public List<String> getComplaints() {
        return complaints;
    }
}

package com.medcenter.models;

import java.util.List;

public class Patient {

    private String name;
    private int age;
    private List<String> complaints;

    public Patient(String name, int age, List<String> complaints) {
        this.name = name;
        this.age = age;
        this.complaints = complaints;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getComplaints() {
        return complaints;
    }
}

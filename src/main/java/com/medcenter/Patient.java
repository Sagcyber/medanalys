package com.medcenter;

import java.util.List;

public class Patient {

    private String name;
    private int age;
    private List<String> complains;

    public Patient(String name, int age, List<String> complains) {
        this.name = name;
        this.age = age;
        this.complains = complains;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getComplains() {
        return complains;
    }
}

package com.medcenter.models;

import java.util.Objects;

public class Test {

    private String name;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(name, test.name) && Objects.equals(description, test.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    public Test(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

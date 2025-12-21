package com.medcenter.models;

import java.util.Objects;
/**
 * Represents a medical test with a name and description.
 */
public class Test {

    private String name;
    private String description;
    /**
     * Constructor to create a Test object.
     *
     * @param name        the test name
     * @param description description of what the test checks
     */
    public Test(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     * @return the test name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the test description
     */
    public String getDescription() {
        return description;
    }

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
}

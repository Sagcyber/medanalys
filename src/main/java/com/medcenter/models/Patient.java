package com.medcenter.models;

//import com.medcenter.enums.Complaint;

import com.medcenter.enums.Complaint;
import com.medcenter.exceptions.InvalidAgeException;
import com.medcenter.exceptions.InvalidComplaintException;
import com.medcenter.exceptions.InvalidNameException;

import java.util.List;
/**
 * Represents a patient with name, age, and list of complaints.
 */
public class Patient {

    private String name;

    private int age;

    private List<Complaint> complaints;

    /**
     * Constructor to create a Patient object.
     *
     * @param name       the patient's name
     * @param age        the patient's age
     * @param complaints list of complaints of the patient
     */

    public Patient(String name, int age, List<Complaint> complaints) throws InvalidComplaintException {
        // Validate name is not empty
        if (name == null || name.isBlank()) {
            throw new InvalidNameException("Name cannot be empty");
            
        }
        // Validate age is positive
        if (age <= 0){
            throw new InvalidAgeException("Age must be positive");
        }
        
        if (complaints == null || complaints.isEmpty()) {
            throw new InvalidComplaintException("Complaints cannot be empty");
        }
        
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
    public List<Complaint> getComplaints() {
        return complaints;
    }
}

package dto;

/**
 * DTO representing input data for patient creation.
 * Used as a transport object between UI/API and service layer.
 */

public class PatientRequest {
    
    private final String name;
    private final int age;
    private final String complaints;
    
    public PatientRequest(String name, int age, String complaints) {
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
    
    public String getComplaints() {
        return complaints;
    }
    
}

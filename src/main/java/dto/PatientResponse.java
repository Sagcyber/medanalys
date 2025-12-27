package dto;

import com.medcenter.models.Test;

import java.util.Set;

public class PatientResponse {
    
    private final String name;
    private final Set<Test> recommendedTests;
    
    public PatientResponse(String name, Set<Test> recommendedTests) {
        this.name = name;
        this.recommendedTests = recommendedTests;
    }
    
    public String getName() {
        return name;
    }
    
    public Set<Test> getRecommendedTests() {
        return recommendedTests;
    }
}

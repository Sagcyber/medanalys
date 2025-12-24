package com.medcenter.enums;

import com.medcenter.exceptions.InvalidComplaintException;

import java.util.Locale;

public enum Complaint {
    HAIR_LOSS("hair loss"),
    FATIGUE("fatigue"),
    HEADACHE("headache");
    
    private final String userComplaint;
    
    Complaint(String userComplaint) {
        this.userComplaint = userComplaint;
    }
    
    public String getUserComplaint(){
        return userComplaint;
    }
    
    public static Complaint fromUserInput(String input)
            throws InvalidComplaintException {
        input = input.trim().toLowerCase(Locale.ROOT);
        
        switch(input){
            case "hair loss":
                return HAIR_LOSS;
            case "fatigue":
                return FATIGUE;
            case "headache":
                return HEADACHE;
            default:
                throw new InvalidComplaintException("Unknown complaint: " + input);
        }
    }
}

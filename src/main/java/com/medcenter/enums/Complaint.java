package com.medcenter.enums;

import java.util.Locale;

public enum Complaint {
    HAIR_LOSS("hair loss"),
    FATIGUE("fatigue"),
    HEADACHE("headache");
    
    private final String userComplaint;
    
    public Complaint(String userComplaint) {
        this.userComplaint = userComplaint;
    }
    
    public String getUserComplaint(){
        return userComplaint;
    }
    
    public static Complaint fromUserInput(String input){
        input = input.trim().toLowerCase(Locale.ROOT);
        
        switch(input){
            case "hair loss":
                return HAIR_LOSS;
            case "fatigue":
                return FATIGUE;
            case "headache":
                return HEADACHE;
            default:
                return null;
        }
    }
    
}

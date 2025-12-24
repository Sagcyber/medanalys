package com.medcenter.exceptions;
/**
 * Custom exception thrown when patient's complaint input is invalid.
 */
public class InvalidComplaintException extends MedAnalysException {
    /**
     * Constructor for InvalidComplaintException.
     *
     * @param message the error message
     */
    public InvalidComplaintException(String message){
        super(message);
    }

}

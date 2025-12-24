package com.medcenter.exceptions;
/**
 * Custom exception thrown when patient's name is invalid.
 */
public class InvalidNameException extends MedAnalysException{
    /**
     * Constructor for InvalidNameException.
     *
     * @param message the error message
     */
    public InvalidNameException(String message) {
        super(message);
    }
}

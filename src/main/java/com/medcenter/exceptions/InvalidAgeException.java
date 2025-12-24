package com.medcenter.exceptions;
/**
 * Custom exception thrown when patient's age is invalid.
 */
public class InvalidAgeException extends MedAnalysException {
    /**
     * Constructor for InvalidAgeException.
     *
     * @param message the error message
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}

package com.medcenter.exceptions;
/**
 * Origin class for all invalid exceptions
 */
public class MedAnalysException extends RuntimeException {
    /**
     * Constructor for MedAnalysException.
     *
     * @param message the error message
     */
    public MedAnalysException(String message) {
        super(message);
    }
}

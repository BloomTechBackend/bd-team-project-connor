package com.connor.handicaptracker.exceptions;

/**
 * Exception to throw when a given Course is not found
 * in the database.
 */
public class CourseNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -1340785223023147290L;

    /**
     * Exception with no message or cause.
     */
    public CourseNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public CourseNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public CourseNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public CourseNotFoundException (String message, Throwable cause) {
        super(message, cause);
    }
}
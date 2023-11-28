package com.connor.handicaptracker.exceptions;

/**
 * Exception to throw when a given Round date and score is not found
 * in the database.
 */
public class RoundNotFoundException extends RuntimeException {
    //private static final long serialVersionUID = -1230785223023147290L;

    /**
     * Exception with no message or cause.
     */
    public RoundNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public RoundNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public RoundNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public RoundNotFoundException (String message, Throwable cause) {
        super(message, cause);
    }
}

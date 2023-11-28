package com.connor.handicaptracker.exceptions;


/**
 * Exception to throw when a given Handicap is not found
 * in the database.
 */
public class HandicapNotFoundException extends RuntimeException {
    //private static final long serialVersionUID = -1230785223023147290L;

    /**
     * Exception with no message or cause.
     */
    public HandicapNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public HandicapNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public HandicapNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public HandicapNotFoundException (String message, Throwable cause) {
        super(message, cause);
    }
}
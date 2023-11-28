package com.connor.handicaptracker.exceptions;


/**
 * Exception to throw when a given Player is not found
 * in the database.
 */
public class PlayerNotFoundException extends RuntimeException {
    //private static final long serialVersionUID = -1230785223023147290L;

    /**
     * Exception with no message or cause.
     */
    public PlayerNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public PlayerNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public PlayerNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public PlayerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
package com.litmus7.rental.vehicle.exception;

/**
 * {@code VehicleFileAccessException} is a custom checked exception thrown when
 * there is an issue accessing or reading the vehicle data file.
 * <p>
 * This exception helps separate file-related failures from other logic errors
 * in the vehicle rental system.
 * </p>
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class VehicleFileAccessException extends Exception {

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * @param message the detail message explaining the error
     * @param cause the cause of the error (can be another exception)
     */
    public VehicleFileAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message explaining the error
     */
    public VehicleFileAccessException(String message) {
        super(message);
    }
}

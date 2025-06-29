package com.litmus7.rental.vehicle.exception;

/**
 * {@code VehicleServiceException} is a custom checked exception used to indicate
 * issues in the business logic of the vehicle service layer.
 * <p>
 * This includes problems like null inputs, invalid operations such as renting
 * an unavailable vehicle, or returning a vehicle that was never rented.
 * </p>
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class VehicleServiceException extends Exception {

    /**
     * Constructs a new VehicleServiceException with the specified detail message.
     *
     * @param message the detail message explaining the cause of the exception
     */
    public VehicleServiceException(String message) {
        super(message);
    }
}

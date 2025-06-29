package com.litmus7.rental.vehicle.dto;

import java.util.List;

/**
 * The {@code Response} class is a generic response wrapper used by the controller
 * to encapsulate results, status codes, messages, vehicle data, and total price.
 * <p>
 * This allows uniform handling of both successful and error responses.
 * </p>
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class Response {

    private int statusCode;
    private String errorMessage;
    private List<Vehicle> vehicles;
    private double totalPrice;

    /**
     * Gets the total rental price included in the response.
     *
     * @return the total price of all vehicles
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total rental price in the response.
     *
     * @param totalPrice total price value to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Gets the status code of the response.
     *
     * @return status code (e.g., 200, 400)
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the status code of the response.
     *
     * @param statusCode the HTTP-like status code to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets the error message, if any.
     *
     * @return error message string
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message in case of failure.
     *
     * @param errorMessage the message describing the error
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Gets the list of vehicles included in the response.
     *
     * @return list of vehicles
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Sets the list of vehicles in the response.
     *
     * @param vehicles the list of vehicles to set
     */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}


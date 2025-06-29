package com.litmus7.rental.vehicle.controller;

import com.litmus7.rental.vehicle.dto.Response;
import com.litmus7.rental.vehicle.dto.Vehicle;
import com.litmus7.rental.vehicle.enums.StatusCode;
import com.litmus7.rental.vehicle.exception.VehicleFileAccessException;
import com.litmus7.rental.vehicle.exception.VehicleServiceException;
import com.litmus7.rental.vehicle.service.VehicleService;

import java.util.List;

/**
 * The {@code VehicleController} class acts as a mediator between UI and the service layer.
 * It handles validation, catches exceptions, and returns standardized {@link Response} objects.
 *
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class VehicleController {

    private final VehicleService vehicleService = new VehicleService();

    /**
     * Loads vehicles from a file.
     *
     * @param filePath the path to the vehicle data file
     * @return response with success or failure status
     */
    public Response loadVehicles(String filePath) {
        Response response = new Response();

        try {
            vehicleService.loadVehiclesFromFile(filePath);
            response.setStatusCode(StatusCode.SUCCESS.getCode());
        } 
        catch (VehicleFileAccessException e) 
        {
            response.setStatusCode(StatusCode.SERVER_ERROR.getCode());
            response.setErrorMessage("File error: " + e.getMessage());
        }

        return response;
    }

    /**
     * Adds a new vehicle.
     *
     * @param vehicle the vehicle to add
     * @return response containing status and added vehicle
     */
    public Response addVehicle(Vehicle vehicle) {
        Response response = new Response();

        try {
            vehicleService.addAVehicle(vehicle);
            response.setStatusCode(StatusCode.CREATED.getCode());
            response.setVehicles(List.of(vehicle));
        } 
        catch (VehicleServiceException e) 
        {
            response.setStatusCode(StatusCode.BAD_REQUEST.getCode());
            response.setErrorMessage("Add failed: " + e.getMessage());
        }

        return response;
    }

    /**
     * Gets all vehicles in the system.
     *
     * @return response containing vehicle list
     */
    public Response getAllVehicles() {
        Response response = new Response();

        response.setStatusCode(StatusCode.SUCCESS.getCode());
        response.setVehicles(vehicleService.getAllVehicles());

        return response;
    }

    /**
     * Gets available (non-rented) vehicles.
     *
     * @return response containing available vehicle list
     */
    public Response getAvailableVehicles() {
        Response response = new Response();

        response.setStatusCode(StatusCode.SUCCESS.getCode());
        response.setVehicles(vehicleService.getAvailableVehicles());

        return response;
    }

    /**
     * Searches vehicles based on a query string.
     *
     * @param query search keyword (brand or model)
     * @return response with matching vehicles or error
     */
    public Response searchVehicles(String query) {
        Response response = new Response();

        try {
            response.setVehicles(vehicleService.searchVehicles(query));
            response.setStatusCode(StatusCode.SUCCESS.getCode());
        } 
        catch (VehicleServiceException e) 
        {
            response.setStatusCode(StatusCode.BAD_REQUEST.getCode());
            response.setErrorMessage("Search failed: " + e.getMessage());
        }

        return response;
    }

    /**
     * Rents a vehicle matching the given brand and model.
     *
     * @param brand the brand of vehicle
     * @param model the model of vehicle
     * @return response indicating success or failure
     */
    public Response rentVehicle(String brand, String model) {
        Response response = new Response();

        try {
            vehicleService.rentVehicle(brand, model);
            response.setStatusCode(StatusCode.SUCCESS.getCode());
        } 
        catch (VehicleServiceException e) 
        {
            response.setStatusCode(StatusCode.BAD_REQUEST.getCode());
            response.setErrorMessage("Rent failed: " + e.getMessage());
        }

        return response;
    }

    /**
     * Returns a previously rented vehicle.
     *
     * @param brand the brand of vehicle
     * @param model the model of vehicle
     * @return response indicating success or failure
     */
    public Response returnVehicle(String brand, String model) {
        Response response = new Response();

        try {
            vehicleService.returnVehicle(brand, model);
            response.setStatusCode(StatusCode.SUCCESS.getCode());
        } 
        catch (VehicleServiceException e) 
        {
            response.setStatusCode(StatusCode.BAD_REQUEST.getCode());
            response.setErrorMessage("Return failed: " + e.getMessage());
        }

        return response;
    }

    /**
     * Calculates the total rental price of all vehicles.
     *
     * @return response containing total price
     */
    public Response getTotalRentalPrice() {
        Response response = new Response();

        response.setStatusCode(StatusCode.SUCCESS.getCode());
        response.setTotalPrice(vehicleService.totalRentalPrice());

        return response;
    }
}

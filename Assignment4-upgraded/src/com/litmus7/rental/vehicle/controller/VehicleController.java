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

    public Response<Void> loadVehicles(String filePath) {
        Response<Void> response = new Response<>();
        try {
            vehicleService.loadVehiclesFromFile(filePath);
            response.setStatusCode(StatusCode.SUCCESS.getCode());
        } catch (VehicleFileAccessException e) {
            response.setStatusCode(StatusCode.SERVER_ERROR.getCode());
            response.setErrorMessage("File error: " + e.getMessage());
        }
        return response;
    }

    public Response<Vehicle> addVehicle(Vehicle vehicle) {
        Response<Vehicle> response = new Response<>();
        try {
            vehicleService.addAVehicle(vehicle);
            response.setStatusCode(StatusCode.CREATED.getCode());
            response.setData(vehicle);
        } catch (VehicleServiceException e) {
            response.setStatusCode(StatusCode.BAD_REQUEST.getCode());
            response.setErrorMessage("Add failed: " + e.getMessage());
        }
        return response;
    }

    public Response<List<Vehicle>> getAllVehicles() {
        Response<List<Vehicle>> response = new Response<>();
        response.setStatusCode(StatusCode.SUCCESS.getCode());
        response.setData(vehicleService.getAllVehicles());
        return response;
    }

    public Response<List<Vehicle>> getAvailableVehicles() {
        Response<List<Vehicle>> response = new Response<>();
        response.setStatusCode(StatusCode.SUCCESS.getCode());
        response.setData(vehicleService.getAvailableVehicles());
        return response;
    }

    public Response<List<Vehicle>> searchVehicles(String query) {
        Response<List<Vehicle>> response = new Response<>();
        try {
            response.setData(vehicleService.searchVehicles(query));
            response.setStatusCode(StatusCode.SUCCESS.getCode());
        } catch (VehicleServiceException e) {
            response.setStatusCode(StatusCode.BAD_REQUEST.getCode());
            response.setErrorMessage("Search failed: " + e.getMessage());
        }
        return response;
    }

    public Response<Void> rentVehicle(String brand, String model) {
        Response<Void> response = new Response<>();
        try {
            vehicleService.rentVehicle(brand, model);
            response.setStatusCode(StatusCode.SUCCESS.getCode());
        } catch (VehicleServiceException e) {
            response.setStatusCode(StatusCode.BAD_REQUEST.getCode());
            response.setErrorMessage("Rent failed: " + e.getMessage());
        }
        return response;
    }

    public Response<Void> returnVehicle(String brand, String model) {
        Response<Void> response = new Response<>();
        try {
            vehicleService.returnVehicle(brand, model);
            response.setStatusCode(StatusCode.SUCCESS.getCode());
        } catch (VehicleServiceException e) {
            response.setStatusCode(StatusCode.BAD_REQUEST.getCode());
            response.setErrorMessage("Return failed: " + e.getMessage());
        }
        return response;
    }

    public Response<Double> getTotalRentalPrice() {
        Response<Double> response = new Response<>();
        response.setStatusCode(StatusCode.SUCCESS.getCode());
        response.setData(vehicleService.totalRentalPrice());
        return response;
    }
}

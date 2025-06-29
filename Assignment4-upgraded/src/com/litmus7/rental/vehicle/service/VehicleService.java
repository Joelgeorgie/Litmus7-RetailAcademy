package com.litmus7.rental.vehicle.service;

import com.litmus7.rental.vehicle.dao.VehicleFileDAO;
import com.litmus7.rental.vehicle.dto.Vehicle;
import com.litmus7.rental.vehicle.exception.VehicleFileAccessException;
import com.litmus7.rental.vehicle.exception.VehicleServiceException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The {@code VehicleService} class provides business logic for managing vehicles
 * in the rental system. It handles loading, adding, searching, renting, returning,
 * and retrieving available vehicles.
 *
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class VehicleService {

    private final ArrayList<Vehicle> vehiclesList = new ArrayList<>();
    private final HashMap<Vehicle, Boolean> vehicleAvailabilityMap = new HashMap<>();

    /**
     * Loads vehicles from a file using the DAO and initializes their availability.
     *
     * @param filePath the path to the vehicle data file
     * @return true if loading is successful
     * @throws VehicleFileAccessException if file read fails or no vehicles are found
     */
    public boolean loadVehiclesFromFile(String filePath) throws VehicleFileAccessException {
        List<Vehicle> loadedVehicles;

        try {
            loadedVehicles = VehicleFileDAO.loadVehicles(filePath);
        } 
        catch (Exception e) 
        {
            throw new VehicleFileAccessException("Failed to load vehicles from file: " + filePath, e);
        }

        if (loadedVehicles == null || loadedVehicles.isEmpty()) {
            throw new VehicleFileAccessException("Vehicle data file is empty or corrupt.");
        }

        for (Vehicle vehicle : loadedVehicles) {
            vehiclesList.add(vehicle);
            vehicleAvailabilityMap.put(vehicle, true);
        }

        return true;
    }

    /**
     * Returns all vehicles currently in the system.
     *
     * @return list of all vehicles
     */
    public ArrayList<Vehicle> getAllVehicles() {
        return vehiclesList;
    }

    /**
     * Adds a new vehicle to the system and marks it as available.
     *
     * @param vehicle the vehicle to add
     * @return confirmation message
     * @throws VehicleServiceException if the vehicle is null
     */
    public String addAVehicle(Vehicle vehicle) throws VehicleServiceException {
        if (vehicle == null) {
            throw new VehicleServiceException("Vehicle object is null.");
        }

        vehiclesList.add(vehicle);
        vehicleAvailabilityMap.put(vehicle, true);

        return "Vehicle added successfully: " + vehicle;
    }

    /**
     * Searches for vehicles matching the brand or model name.
     *
     * @param query brand or model keyword
     * @return list of matched vehicles
     * @throws VehicleServiceException if query is null or empty
     */
    public ArrayList<Vehicle> searchVehicles(String query) throws VehicleServiceException {
        if (query == null || query.isBlank()) {
            throw new VehicleServiceException("Search query cannot be null or blank.");
        }

        query = query.toLowerCase();
        ArrayList<Vehicle> matchedVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehiclesList) {
            if (vehicle.getBrand().toLowerCase().contains(query)
                    || vehicle.getModel().toLowerCase().contains(query)) {
                matchedVehicles.add(vehicle);
            }
        }

        return matchedVehicles;
    }

    /**
     * Calculates the total rental price for all vehicles in the system.
     *
     * @return total price
     */
    public double totalRentalPrice() {
        double total = 0;
        for (Vehicle vehicle : vehiclesList) {
            total += vehicle.getRentalPricePerDay();
        }
        return total;
    }

    /**
     * Marks a vehicle as rented, if it exists and is available.
     *
     * @param brand the brand to rent
     * @param model the model to rent
     * @return success message
     * @throws VehicleServiceException if input is invalid, vehicle not found, or unavailable
     */
    public String rentVehicle(String brand, String model) throws VehicleServiceException {
        if (brand == null || model == null || brand.isBlank() || model.isBlank()) {
            throw new VehicleServiceException("Brand and model must not be null or blank.");
        }

        brand = brand.toLowerCase();
        model = model.toLowerCase();

        for (Vehicle vehicle : vehiclesList) {
            if (vehicle.getBrand().toLowerCase().contains(brand)
                    && vehicle.getModel().toLowerCase().contains(model)) {

                if (vehicleAvailabilityMap.getOrDefault(vehicle, false)) {
                    vehicleAvailabilityMap.put(vehicle, false);
                    return "Vehicle rented successfully: " + vehicle;
                } 
                else 
                {
                    throw new VehicleServiceException("Vehicle is currently not available.");
                }
            }
        }

        throw new VehicleServiceException("No such vehicle found in the system.");
    }

    /**
     * Marks a rented vehicle as returned.
     *
     * @param brand the brand to return
     * @param model the model to return
     * @return success message
     * @throws VehicleServiceException if vehicle is not found or not rented
     */
    public String returnVehicle(String brand, String model) throws VehicleServiceException {
        if (brand == null || model == null || brand.isBlank() || model.isBlank()) {
            throw new VehicleServiceException("Brand and model must not be null or blank.");
        }

        brand = brand.toLowerCase();
        model = model.toLowerCase();

        for (Vehicle vehicle : vehiclesList) {
            if (vehicle.getBrand().toLowerCase().contains(brand)
                    && vehicle.getModel().toLowerCase().contains(model)) {

                if (!vehicleAvailabilityMap.getOrDefault(vehicle, true)) {
                    vehicleAvailabilityMap.put(vehicle, true);
                    return "Vehicle returned successfully: " + vehicle;
                } 
                else 
                {
                    throw new VehicleServiceException("Vehicle is already available (not rented).");
                }
            }
        }

        throw new VehicleServiceException("No such vehicle found in the system.");
    }

    /**
     * Returns list of all available vehicles.
     *
     * @return list of available vehicles
     */
    public ArrayList<Vehicle> getAvailableVehicles() {
        ArrayList<Vehicle> availableVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehiclesList) {
            if (vehicleAvailabilityMap.getOrDefault(vehicle, false)) {
                availableVehicles.add(vehicle);
            }
        }

        return availableVehicles;
    }
}

package com.litmus7.rental.vehicle;

import com.litmus7.rental.vehicle.service.VehicleService;

/**
 * The {@code VehicleApp} class serves as the entry point for the Vehicle Rental System.
 * <p>
 * It demonstrates the functionality of {@link VehicleService} by loading vehicles
 * from a file, displaying them, adding a new vehicle, searching, renting, returning,
 * and showing availability.
 * </p>
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class VehicleApp {

	public static void main(String[] args) {

		VehicleService vehicleService = new VehicleService();

		// Load vehicle data from file
		System.out.println("Loading vehicles from file: vehicles.txt");
		vehicleService.loadVehiclesFromFile();
		vehicleService.displayVehicles();

		// Add a new vehicle using user input
		vehicleService.addAVehicle();
		vehicleService.displayVehicles();

		// Search for vehicles based on brand or model
		String query = "Honda";
		System.out.println("Searching vehicles using the search parameter: " + query);
		vehicleService.searchVehicles(query);
		System.out.println("--- Search Results Above ---");

		// Calculate and display total rental price of all vehicles
		double totalRentalPriceForAllVehicles = vehicleService.totalRentalPrice();
		System.out.println();
		System.out.println("Total Rental Price for all the vehicles: " + totalRentalPriceForAllVehicles);
		System.out.println();

		// Display currently available vehicles
		vehicleService.displayAvailableVehicles();

		// Rent a few vehicles
		System.out.println("--- Renting Vehicles ---");
		vehicleService.rentVehicle("Yamaha", "R15");
		vehicleService.rentVehicle("Ford", "Focus");

		// Display availability after rentals
		vehicleService.displayAvailableVehicles();

		// Return a vehicle
		System.out.println("--- Returning Vehicles ---");
		vehicleService.returnVehicle("Yamaha", "R15");

		// Display updated availability
		vehicleService.displayAvailableVehicles();
	}
}


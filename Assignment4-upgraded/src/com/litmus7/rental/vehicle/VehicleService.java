package com.litmus7.rental.vehicle;

import com.litmus7.rental.vehicle.dto.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * The {@code VehicleService} class provides services to manage vehicles in the rental system.
 * It supports operations like loading vehicles from a file, adding vehicles, displaying
 * available/all vehicles, renting, returning, searching, and calculating total rental value.
 * 
 * <p>Each vehicle's availability is tracked using a map. Vehicles are stored in a list for easy iteration.</p>
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class VehicleService {

	private ArrayList<Vehicle> vehiclesList = new ArrayList<>();
	private HashMap<Vehicle, Boolean> vehicleAvailabilityMap = new HashMap<>();

	/**
	 * Loads vehicle data from a file named {@code vehicles.txt}, parses it, and
	 * adds each valid vehicle (Car/Bike) to the system.
	 */
	public void loadVehiclesFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("vehicles.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					String type = parts[0].trim();
					String brand = parts[1].trim();
					String model = parts[2].trim();
					double rentalPricePerDay = Double.parseDouble(parts[3].trim());

					if (type.equalsIgnoreCase("car")) {
						int numberOfDoors = Integer.parseInt(parts[4].trim());
						boolean isAutomatic = Boolean.parseBoolean(parts[5].trim());
						Car car = new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic);
						vehiclesList.add(car);
						vehicleAvailabilityMap.put(car, true);

					} else if (type.equalsIgnoreCase("bike")) {
						boolean hasGear = Boolean.parseBoolean(parts[4].trim());
						int engineCapacity = Integer.parseInt(parts[5].trim());
						Bike bike = new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity);
						vehiclesList.add(bike);
						vehicleAvailabilityMap.put(bike, true);
					}
				} else {
					System.out.println("Skipping invalid line: " + line);
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading vehicle file: " + e.getMessage());
		}
	}


	/**
	 * Displays all vehicles in the system.
	 */
	public void displayVehicles() {
		System.out.println("\n---- List of Vehicles ----");
		for (Vehicle vehicle : vehiclesList) {
			System.out.println(vehicle);
		}
		System.out.println("---------------------------------------------------------------------------\n");
	}

	/**
	 * Prompts the user to input a new vehicle (Car or Bike) and adds it to the system.
	 */
	public void addAVehicle() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the type of vehicle (Car/Bike): ");
		String vehicleType = scanner.next();

		if (vehicleType.equalsIgnoreCase("Car")) {
			Car car = new Car();
			car.inputDetails();
			vehiclesList.add(car);
			vehicleAvailabilityMap.put(car, true);

		} else if (vehicleType.equalsIgnoreCase("Bike")) {
			Bike bike = new Bike();
			bike.inputDetails();
			vehiclesList.add(bike);
			vehicleAvailabilityMap.put(bike, true);

		} else {
			System.out.println("Invalid vehicle type.");
		}
	}

	/**
	 * Searches for vehicles by brand or model (case-insensitive) and displays matches.
	 *
	 * @param query the search term to match against brand or model
	 */
	public void searchVehicles(String query) {
		query = query.toLowerCase();
		for (Vehicle vehicle : vehiclesList) {
			if (vehicle.getBrand().toLowerCase().contains(query) || vehicle.getModel().toLowerCase().contains(query)) {
				System.out.println(vehicle);
			}
		}
	}

	/**
	 * Calculates and returns the total rental price of all vehicles in the system.
	 *
	 * @return total rental price per day of all vehicles
	 */
	public double totalRentalPrice() {
		double total = 0;
		for (Vehicle vehicle : vehiclesList) {
			total += vehicle.getRentalPricePerDay();
		}
		return total;
	}

	/**
	 * Rents a vehicle by brand and model if it is currently available.
	 *
	 * @param brand the brand of the vehicle
	 * @param model the model of the vehicle
	 */
	public void rentVehicle(String brand, String model) {
		brand = brand.toLowerCase();
		model = model.toLowerCase();

		for (Vehicle vehicle : vehiclesList) {
			if (vehicle.getBrand().toLowerCase().contains(brand)
					&& vehicle.getModel().toLowerCase().contains(model)
					&& vehicleAvailabilityMap.getOrDefault(vehicle, false)) {

				vehicleAvailabilityMap.replace(vehicle, false);
				System.out.println("The vehicle has been allotted: " + vehicle);
				return;
			}
		}
		System.out.println("This vehicle is not available.");
	}

	/**
	 * Returns a rented vehicle back to the system and marks it as available.
	 *
	 * @param brand the brand of the vehicle
	 * @param model the model of the vehicle
	 */
	public void returnVehicle(String brand, String model) {
		brand = brand.toLowerCase();
		model = model.toLowerCase();

		for (Vehicle vehicle : vehiclesList) {
			if (vehicle.getBrand().toLowerCase().contains(brand)
					&& vehicle.getModel().toLowerCase().contains(model)
					&& !vehicleAvailabilityMap.get(vehicle)) {

				vehicleAvailabilityMap.replace(vehicle, true);
				System.out.println("The vehicle has been returned: " + vehicle);
				return;
			}
		}
		System.out.println("This vehicle cannot be returned.");
	}

	/**
	 * Displays only the vehicles that are currently available for rent.
	 */
	public void displayAvailableVehicles() {
		System.out.println("\n---- List of Available Vehicles ----");
		for (Vehicle vehicle : vehiclesList) {
			if (vehicleAvailabilityMap.getOrDefault(vehicle, false)) {
				System.out.println(vehicle);
			}
		}
		System.out.println("---------------------------------------------------------------------------\n");
	}
}

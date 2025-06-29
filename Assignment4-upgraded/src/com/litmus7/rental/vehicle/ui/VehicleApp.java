package com.litmus7.rental.vehicle.ui;

import com.litmus7.rental.vehicle.controller.VehicleController;
import com.litmus7.rental.vehicle.dto.Response;
import com.litmus7.rental.vehicle.dto.Vehicle;
import com.litmus7.rental.vehicle.enums.StatusCode;
import com.litmus7.rental.vehicle.dto.Car;

import java.util.List;

/**
 * The {@code VehicleApp} class serves as the entry point for the Vehicle Rental System.
 * <p>
 * It demonstrates the functionality of {@link VehicleController} by loading vehicles,
 * adding new vehicles, searching, renting, returning, and displaying availability.
 * </p>
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class VehicleApp {

    /**
     * The main method that drives the vehicle rental system.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        VehicleController controller = new VehicleController();

        System.out.println("Loading vehicles from file: vehicles.txt");
        Response loadResponse = controller.loadVehicles("vehicles.txt");

        if (requestSucceeded(loadResponse)) {
            System.out.println("✅ Vehicles loaded successfully.");
        } 
        else {
            System.out.println("❌ Failed to load vehicles: " + loadResponse.getErrorMessage());
        }

        System.out.println("\n---- List of All Vehicles ----");
        Response allVehiclesResponse = controller.getAllVehicles();

        if (requestSucceeded(allVehiclesResponse)) {
            printVehicles(allVehiclesResponse.getVehicles());
        } 
        else {
            System.out.println("❌ Failed to fetch vehicle list: " + allVehiclesResponse.getErrorMessage());
        }

        Vehicle newVehicle = new Car("Nissan", "Altima", 55.0, 4, true);
        System.out.println("\nAdding new vehicle: " + newVehicle);
        Response addResponse = controller.addVehicle(newVehicle);

        if (requestSucceeded(addResponse)) {
            System.out.println("✅ Vehicle added successfully.");
        } 
        else {
            System.out.println("❌ Failed to add vehicle: " + addResponse.getErrorMessage());
        }

        System.out.println("\n---- Updated Vehicle List ----");
        Response updatedVehiclesResponse = controller.getAllVehicles();

        if (requestSucceeded(updatedVehiclesResponse)) {
            printVehicles(updatedVehiclesResponse.getVehicles());
        } 
        else {
            System.out.println("❌ Failed to fetch updated vehicle list.");
        }

        String query = "Honda";
        System.out.println("\nSearching vehicles with query: " + query);
        Response searchResponse = controller.searchVehicles(query);

        if (requestSucceeded(searchResponse)) {
            printVehicles(searchResponse.getVehicles());
        } 
        else {
            System.out.println("❌ Search failed: " + searchResponse.getErrorMessage());
        }

        System.out.println("\nTotal rental price of all vehicles:");
        Response priceResponse = controller.getTotalRentalPrice();

        if (requestSucceeded(priceResponse)) {
            System.out.println("Total Price: $" + priceResponse.getTotalPrice());
        } 
        else {
            System.out.println("❌ Could not calculate total rental price.");
        }

        System.out.println("\n---- Available Vehicles ----");
        Response availableResponse = controller.getAvailableVehicles();

        if (requestSucceeded(availableResponse)) {
            printVehicles(availableResponse.getVehicles());
        } 
        else {
            System.out.println("❌ Failed to get available vehicles.");
        }

        System.out.println("\n--- Renting Vehicles ---");
        Response rent1 = controller.rentVehicle("Yamaha", "R15");

        if (requestSucceeded(rent1)) {
            System.out.println("✅ Yamaha R15 rented successfully.");
        } 
        else {
            System.out.println("❌ Rent failed: " + rent1.getErrorMessage());
        }

        Response rent2 = controller.rentVehicle("Ford1", "Focus");

        if (requestSucceeded(rent2)) {
            System.out.println("✅ Ford Focus rented successfully.");
        } 
        else {
            System.out.println("❌ Rent failed: " + rent2.getErrorMessage());
        }

        System.out.println("\n---- Available Vehicles After Renting ----");
        Response afterRentAvailable = controller.getAvailableVehicles();

        if (requestSucceeded(afterRentAvailable)) {
            printVehicles(afterRentAvailable.getVehicles());
        } 
        else {
            System.out.println("❌ Failed to fetch available vehicles.");
        }

        System.out.println("\n--- Returning Vehicles ---");
        Response returnResponse = controller.returnVehicle("Yamaha", "R15");

        if (requestSucceeded(returnResponse)) {
            System.out.println("✅ Yamaha R15 returned successfully.");
        } 
        else {
            System.out.println("❌ Return failed: " + returnResponse.getErrorMessage());
        }

        System.out.println("\n---- Available Vehicles After Return ----");
        Response afterReturnAvailable = controller.getAvailableVehicles();

        if (requestSucceeded(afterReturnAvailable)) {
            printVehicles(afterReturnAvailable.getVehicles());
        } 
        else {
            System.out.println("❌ Failed to fetch available vehicles.");
        }
    }

    /**
     * Checks if the response indicates success or creation.
     *
     * @param response the response object to check
     * @return {@code true} if the status code is SUCCESS or CREATED; otherwise {@code false}
     */
    private static boolean requestSucceeded(Response response) {
        return response.getStatusCode() == StatusCode.SUCCESS.getCode()
            || response.getStatusCode() == StatusCode.CREATED.getCode();
    }

    /**
     * Prints the list of vehicles to the console.
     *
     * @param vehicles the list of vehicles to print
     */
    private static void printVehicles(List<Vehicle> vehicles) {
        if (vehicles != null && !vehicles.isEmpty()) {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        } 
        else {
            System.out.println("No vehicles found.");
        }
    }
}

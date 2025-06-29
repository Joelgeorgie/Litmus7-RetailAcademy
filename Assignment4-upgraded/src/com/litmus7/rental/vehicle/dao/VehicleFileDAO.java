package com.litmus7.rental.vehicle.dao;

import com.litmus7.rental.vehicle.dto.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Utility class for loading vehicle data from a file.
 * Provides a static method to parse and load vehicles into memory.
 */
public class VehicleFileDAO {

    /**
     * Loads vehicles from the given file path and returns a list of Vehicle objects.
     *
     * @param filePath the path to the vehicle data file
     * @return list of loaded vehicles (Car or Bike)
     */
    public static List<Vehicle> loadVehicles(String filePath) {
        List<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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
                        vehicles.add(new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic));
                    } else if (type.equalsIgnoreCase("bike")) {
                        boolean hasGear = Boolean.parseBoolean(parts[4].trim());
                        int engineCapacity = Integer.parseInt(parts[5].trim());
                        vehicles.add(new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity));
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading vehicle file: " + e.getMessage());
        }

        return vehicles;
    }
}

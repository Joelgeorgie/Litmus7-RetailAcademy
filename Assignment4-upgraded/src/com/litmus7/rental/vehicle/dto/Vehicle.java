package com.litmus7.rental.vehicle.dto;

import java.util.Scanner;

/**
 * The {@code Vehicle} class serves as the base class representing a generic vehicle 
 * with attributes such as brand, model, and rental price per day.
 * <p>
 * It provides constructors for initialization, along with methods for user input 
 * and displaying vehicle details. This class is intended to be extended by 
 * specialized vehicle types like {@link Car} and {@link Bike}.
 * </p>
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class Vehicle {

    // ------------------- Fields -------------------

    /**
     * The brand of the vehicle (e.g., Toyota, Yamaha).
     */
    private String brand;

    /**
     * The model of the vehicle (e.g., Corolla, R15).
     */
    private String model;

    /**
     * Rental cost per day for this vehicle.
     */
    private double rentalPricePerDay;

    // ------------------- Constructors -------------------

    /**
     * Default constructor that initializes brand and model to {@code null}
     * and rental price per day to {@code 0.0}.
     */
    public Vehicle() {
        this.brand = null;
        this.model = null;
        this.rentalPricePerDay = 0.0;
    }

    /**
     * Parameterized constructor to initialize a vehicle with given brand, model, and rental price.
     *
     * @param brand             the brand of the vehicle
     * @param model             the model of the vehicle
     * @param rentalPricePerDay the rental price per day
     */
    public Vehicle(String brand, String model, double rentalPricePerDay) {
        this.brand = brand;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    // ------------------- Getters -------------------

    /**
     * @return the brand of the vehicle
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return the model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * @return the rental price per day
     */
    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    // ------------------- Methods -------------------

    /**
     * Prompts the user to input details for the vehicle using a {@code Scanner}.
     */
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter brand: ");
        this.brand = scanner.nextLine();

        System.out.print("Enter model: ");
        this.model = scanner.nextLine();

        System.out.print("Enter rental price per day: ");
        this.rentalPricePerDay = scanner.nextDouble();

        
    }

    /**
     * Displays the vehicle's brand, model, and rental price per day.
     */
    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rental Price/Day: " + rentalPricePerDay);
    }

    /**
     * Returns a string representation of the vehicle.
     *
     * @return string containing brand, model, and rental price
     */
    @Override
    public String toString() {
        return "brand=" + brand + ", model=" + model + ", rentalPricePerDay=" + rentalPricePerDay;
    }
}

package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * The {@code Vehicle} class serves as a base class representing a generic
 * vehicle with attributes such as brand, model, and rental price per day.
 * <p>
 * It provides constructors to initialize vehicle details and methods to input
 * and display those details. This class is intended to be extended by more
 * specific vehicle types like {@code Car} and {@code Bike}.
 * </p>
 * 
 * @author Joel Georgie
 */
public class Vehicle {

	private String brand;
	private String model;
	private double rentalPricePerDay;

	/**
	 * Default constructor that initializes brand and model to {@code null} and
	 * rental price per day to {@code 0.0}.
	 */
	public Vehicle() {
		brand = null;
		model = null;
		rentalPricePerDay = 0.0;
	}

	/**
	 * Parameterized constructor to initialize a vehicle with specific details.
	 *
	 * @param brand             the brand of the vehicle
	 * @param model             the model of the vehicle
	 * @param rentalPricePerDay the rental cost per day for the vehicle
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Prompts the user to input details for the vehicle (brand, model, and rental
	 * price). Uses a {@code Scanner} to read from standard input.
	 */
	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter brand: ");
		brand = scanner.nextLine();
		System.out.print("Enter model: ");
		model = scanner.nextLine();
		System.out.print("Enter rental price per day: ");
		rentalPricePerDay = scanner.nextDouble();
	}

	/**
	 * Displays the vehicle's brand, model, and rental price per day.
	 */
	public void displayDetails() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Rental Price/Day: " + rentalPricePerDay);
	}
}

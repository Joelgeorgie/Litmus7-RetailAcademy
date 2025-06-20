package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * The {@code Car} class extends the {@link Vehicle} class and represents a car
 * with additional properties such as number of doors and whether it is
 * automatic.
 * <p>
 * It includes methods to input and display car-specific details in addition to
 * inherited vehicle details.
 * </p>
 * 
 * @author Joel Georgie
 */
public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;

	/**
	 * Default constructor that initializes the car with preset values:
	 * <ul>
	 * <li>Brand: Honda</li>
	 * <li>Model: Civic</li>
	 * <li>Rental Price/Day: 1400</li>
	 * <li>Number of Doors: 4</li>
	 * <li>Is Automatic: false</li>
	 * </ul>
	 */
	public Car() {
		super("Honda", "Civic", 1400);
		numberOfDoors = 4;
		isAutomatic = false;
	}

	/**
	 * Parameterized constructor to initialize a car with specified values.
	 *
	 * @param brand             the brand of the car
	 * @param model             the model of the car
	 * @param rentalPricePerDay the rental cost per day for the car
	 * @param numberOfDoors     the number of doors in the car
	 * @param isAutomatic       {@code true} if the car is automatic, {@code false}
	 *                          otherwise
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Prompts the user to input car-specific details such as number of doors and
	 * whether the car is automatic. Also calls {@code inputDetails()} from the
	 * {@code Vehicle} superclass to input base details.
	 */
	public void inputDetails() {
		super.inputDetails();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of doors:  ");
		numberOfDoors = scanner.nextInt();
		System.out.print("Is it automatic (true/false)? ");
		isAutomatic = scanner.nextBoolean();
	}

	/**
	 * Displays the details of the car including brand, model, rental price, number
	 * of doors, and whether it is automatic.
	 */
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Number of Doors: " + numberOfDoors);
		System.out.println("Automatic: " + isAutomatic);
	}
}

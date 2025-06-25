package com.litmus7.rental.vehicle.dto;

import java.util.Scanner;

/**
 * The {@code Car} class extends the {@link Vehicle} class and represents a car
 * with additional properties such as number of doors and whether it is automatic.
 * <p>
 * It overrides methods to input and display car-specific details in addition to
 * those inherited from the {@code Vehicle} class.
 * </p>
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;

	/**
	 * Default constructor that initializes the car with preset values:
	 * <ul>
	 *   <li>Brand: Honda</li>
	 *   <li>Model: Civic</li>
	 *   <li>Rental Price/Day: 1400</li>
	 *   <li>Number of Doors: 4</li>
	 *   <li>Is Automatic: false</li>
	 * </ul>
	 */
	public Car() {
		super("Honda", "Civic", 1400);
		this.numberOfDoors = 4;
		this.isAutomatic = false;
	}

	/**
	 * Parameterized constructor to initialize a car with specified values.
	 *
	 * @param brand             the brand of the car
	 * @param model             the model of the car
	 * @param rentalPricePerDay the rental cost per day for the car
	 * @param numberOfDoors     the number of doors in the car
	 * @param isAutomatic       whether the car is automatic
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
	@Override
	public void inputDetails() {
		super.inputDetails();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of doors: ");
		this.numberOfDoors = scanner.nextInt();

		System.out.print("Is it automatic (true/false)? ");
		this.isAutomatic = scanner.nextBoolean();

		// Do not close shared scanner (System.in)
	}

	/**
	 * Displays the details of the car including brand, model, rental price,
	 * number of doors, and whether it is automatic.
	 */
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Number of Doors: " + numberOfDoors);
		System.out.println("Automatic: " + isAutomatic);
	}

	/**
	 * Returns a string representation of the car including vehicle and car-specific details.
	 *
	 * @return a string describing the car
	 */
	@Override
	public String toString() {
		return "Car [" + super.toString() + ", numberOfDoors=" + numberOfDoors + ", isAutomatic=" + isAutomatic + "]";
	}
}

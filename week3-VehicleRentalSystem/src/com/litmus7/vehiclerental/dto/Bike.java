package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * The {@code Bike} class extends the {@link Vehicle} class and represents a
 * bike with additional attributes such as whether it has gears and its engine
 * capacity.
 * <p>
 * It includes functionality to input and display bike-specific details along
 * with inherited vehicle properties.
 * </p>
 * 
 * @author Joel Georgie
 */
public class Bike extends Vehicle {

	private boolean hasGear;
	private int engineCapacity;

	/**
	 * Default constructor that initializes the bike with preset values:
	 * <ul>
	 * <li>Brand: Suzuki</li>
	 * <li>Model: Gixxer</li>
	 * <li>Rental Price/Day: 600</li>
	 * <li>Has Gear: false</li>
	 * <li>Engine Capacity: 125 cc</li>
	 * </ul>
	 */
	public Bike() {
		super("Suzuki", "Gixxer", 600);
		hasGear = false;
		engineCapacity = 125;
	}

	/**
	 * Parameterized constructor to initialize a bike with specific values.
	 *
	 * @param brand             the brand of the bike
	 * @param model             the model of the bike
	 * @param rentalPricePerDay the rental cost per day for the bike
	 * @param hasGear           {@code true} if the bike has gear, {@code false}
	 *                          otherwise
	 * @param engineCapacity    the engine capacity of the bike in cc
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Prompts the user to input bike-specific details such as whether it has gear
	 * and the engine capacity. Also calls {@code inputDetails()} of the superclass
	 * to input base vehicle details.
	 */
	public void inputDetails() {
		super.inputDetails();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Does it have gears (true/false)?  ");
		hasGear = scanner.nextBoolean();
		System.out.print("Enter engine capacity (cc): ");
		engineCapacity = scanner.nextInt();
	}

	/**
	 * Displays the bike’s complete details including inherited vehicle properties,
	 * and bike-specific attributes such as gear availability and engine capacity.
	 */
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Has Gear:  " + hasGear);
		System.out.println("Engine Capacity:  " + engineCapacity + " cc");
	}
}

package com.litmus7.rental.vehicle.dto;

import java.util.Scanner;

/**
 * The {@code Bike} class extends the {@link Vehicle} class and represents a
 * bike with additional attributes such as whether it has gears and its engine
 * capacity.
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class Bike extends Vehicle {

	private boolean hasGear;
	private int engineCapacity;

	/**
	 * Default constructor that initializes the bike with preset values:
	 * <ul>
	 *   <li>Brand: Suzuki</li>
	 *   <li>Model: Gixxer</li>
	 *   <li>Rental Price/Day: 600</li>
	 *   <li>Has Gear: false</li>
	 *   <li>Engine Capacity: 125 cc</li>
	 * </ul>
	 */
	public Bike() {
		super("Suzuki", "Gixxer", 600);
		this.hasGear = false;
		this.engineCapacity = 125;
	}

	/**
	 * Parameterized constructor to initialize a bike with specific values.
	 *
	 * @param brand             the brand of the bike
	 * @param model             the model of the bike
	 * @param rentalPricePerDay the rental cost per day for the bike
	 * @param hasGear           whether the bike has gear
	 * @param engineCapacity    the engine capacity of the bike in cc
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	

	/**
	 * Returns a string representation of the bike object including both
	 * vehicle and bike-specific fields.
	 *
	 * @return a string describing the bike
	 */
	@Override
	public String toString() {
		return "Bike [" + super.toString() + ", hasGear=" + hasGear + ", engineCapacity=" + engineCapacity + "]";
	}
}

package com.litmus7.vehiclerental;

import com.litmus7.vehiclerental.dto.*;

/**
 * The {@code VehicleApp} class demonstrates the usage of the {@code Car} and
 * {@code Bike} classes by creating objects, displaying default values,
 * accepting user input, and using parameterized constructors.
 * <p>
 * This application serves as a simple example of inheritance, encapsulation,
 * and object-oriented design in Java.
 * </p>
 * 
 * @author Joel Georgie
 */
public class VehicleApp {

	/**
	 * The main method is the entry point of the program. It performs the following
	 * tasks:
	 * <ul>
	 * <li>Creates car and bike objects using default constructors</li>
	 * <li>Displays their default values</li>
	 * <li>Accepts user input to initialize the objects</li>
	 * <li>Creates and displays car and bike objects using parameterized
	 * constructors</li>
	 * </ul>
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {

		// Creating a car and bike objects using the default constructor
		Car car = new Car();
		System.out.println("--- Displaying Default Car Details ---");
		car.displayDetails();

		Bike bike = new Bike();
		System.out.println("--- Displaying Default Bike Details ---");
		bike.displayDetails();

		System.out.println();

		// Using the inputDetails method to initialize the objects
		System.out.println("--- Enter Car Details ---");
		car.inputDetails();
		System.out.println("--- Displaying Car Details (Interactive) ---");
		car.displayDetails();

		System.out.println();

		System.out.println("--- Enter Bike Details ---");
		bike.inputDetails();
		System.out.println("--- Displaying Bike Details (Interactive) ---");
		bike.displayDetails();

		System.out.println();

		// Creating the objects using parameterized constructors
		Car car2 = new Car("Tesla", "Model S", 10000, 4, true);
		System.out.println("--- Displaying Car Details (Parameterized)  ---");
		car2.displayDetails();

		System.out.println();

		Bike bike2 = new Bike("Royal Enfield", "Classic360", 3000, true, 350);
		System.out.println("--- Displaying Bike Details (Parameterized) ---");
		bike2.displayDetails();
	}

}

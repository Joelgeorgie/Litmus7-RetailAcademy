package com.litmus7.retail.discount.ui;

import com.litmus7.retail.discount.customermodels.*;
import com.litmus7.retail.discount.interfaces.Discountable;
import java.util.Scanner;

/**
 * Entry point for the Retail Discount System. Prompts the user for customer
 * type and purchase amount, applies appropriate discount based on customer
 * type, and displays results.
 * 
 * Supported customer types: 1 - Regular 2 - Premium 3 - Wholesale
 * 
 * Outputs: - Customer type - Original amount - Discount applied - Final payable
 * amount
 * 
 * Author: Joel Georgie
 */
public class RetailStoreApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Get customer type
		System.out.print("Enter customer type (1- Regular, 2- Premium, 3- Wholesale): ");
		int choice = scanner.nextInt();

		// Get total purchase amount
		System.out.print("Enter total purchase amount: ₹");
		double totalPurchaseAmount = scanner.nextDouble();

		Discountable customer = null;

		// Instantiate customer object based on choice
		switch (choice) {
		case 1:
			customer = new RegularCustomer();
			break;
		case 2:
			customer = new PremiumCustomer();
			break;
		case 3:
			customer = new WholesaleCustomer();
			break;
		default:
			System.out.println("Invalid customer type!");
			scanner.close();
			return;
		}

		// Calculate discount
		double finalAmount = customer.applyDiscount(totalPurchaseAmount);
		double discount = totalPurchaseAmount - finalAmount;

		// Display results
		System.out.println("Customer Type: " + customer.getClass().getSimpleName());
		System.out.printf("Original Amount: ₹%.2f%n", totalPurchaseAmount);
		System.out.printf("Discount Applied: ₹%.2f%n", discount);
		System.out.printf("Final Payable Amount: ₹%.2f%n", finalAmount);

		scanner.close();
	}
}

package com.litmus7.retail.discount.customermodels;

import com.litmus7.retail.discount.interfaces.Discountable;

/**
 * The {@code RegularCustomer} class represents a customer of type "Regular" who
 * receives a fixed percentage discount on the total bill.
 * <p>
 * This class implements the {@link Discountable} interface and applies a
 * standard 5% discount to any given total amount.
 * </p>
 * 
 * Example: If the total amount is 1000, the final amount will be 950.
 * 
 * @author Joel
 */
public class RegularCustomer implements Discountable {

	/**
	 * The discount percentage applicable to regular customers.
	 */
	private double discount = 5;

	/**
	 * Applies a 5% discount to the specified total amount.
	 *
	 * @param totalAmount the original total amount before discount
	 * @return the final amount after applying the 5% discount
	 */
	@Override
	public double applyDiscount(double totalAmount) {
		return (100 - discount) * 0.01 * totalAmount;
	}
}

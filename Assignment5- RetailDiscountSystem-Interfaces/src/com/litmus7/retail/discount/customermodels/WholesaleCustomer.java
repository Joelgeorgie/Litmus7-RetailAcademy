package com.litmus7.retail.discount.customermodels;

import com.litmus7.retail.discount.interfaces.Discountable;

/**
 * The {@code WholesaleCustomer} class represents a customer of type "Wholesale"
 * who receives a variable discount based on the total purchase amount.
 * <p>
 * This class implements the {@link Discountable} interface and applies:
 * <ul>
 *   <li>15% discount if the total amount exceeds 10,000</li>
 *   <li>10% discount otherwise</li>
 * </ul>
 * </p>
 * 
 * Example:  
 * For a total of 12,000, final amount = 12,000 - 15% = 10,200  
 * For a total of 8,000, final amount = 8,000 - 10% = 7,200
 * 
 * @author Joel
 */
public class WholesaleCustomer implements Discountable {

    /**
     * The discount percentage applied based on the total amount.
     */
    private double discount;

    /**
     * Applies a discount based on the total amount:
     * <ul>
     *   <li>15% if totalAmount &gt; 10,000</li>
     *   <li>10% otherwise</li>
     * </ul>
     *
     * @param totalAmount the original total amount before discount
     * @return the final amount after applying the applicable discount
     */
    @Override
    public double applyDiscount(double totalAmount) {
        if (totalAmount > 10000) {
            discount = 15;
        } else {
            discount = 10;
        }

        return (100 - discount) * 0.01 * totalAmount;
    }
}

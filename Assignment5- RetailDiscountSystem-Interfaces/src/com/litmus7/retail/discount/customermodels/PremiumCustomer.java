package com.litmus7.retail.discount.customermodels;

import com.litmus7.retail.discount.interfaces.Discountable;

/**
 * The {@code PremiumCustomer} class represents a customer of type "Premium"
 * who receives a variable discount based on the total bill amount.
 * <p>
 * This class implements the {@link Discountable} interface and applies:
 * <ul>
 *   <li>10% discount if the total amount exceeds 5000</li>
 *   <li>7% discount otherwise</li>
 * </ul>
 * </p>
 * 
 * Example:  
 * For a total of 6000, final amount = 6000 - 10% = 5400  
 * For a total of 4000, final amount = 4000 - 7% = 3720
 * 
 * @author Joel
 */
public class PremiumCustomer implements Discountable {

    /**
     * The discount percentage applied based on the total amount.
     */
    private double discount;

    /**
     * Applies a discount based on the total amount:
     * <ul>
     *   <li>10% if totalAmount &gt; 5000</li>
     *   <li>7% otherwise</li>
     * </ul>
     *
     * @param totalAmount the original total amount before discount
     * @return the final amount after applying the applicable discount
     */
    @Override
    public double applyDiscount(double totalAmount) {
        if (totalAmount > 5000) {
            discount = 10;
        } else {
            discount = 7;
        }

        return (100 - discount) * 0.01 * totalAmount;
    }
}


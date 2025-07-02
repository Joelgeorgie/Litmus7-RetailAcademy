package com.litmus7.retail.discount.interfaces;

/**
 * The {@code Discountable} interface defines a contract for applying 
 * discounts to a given total amount. 
 * <p>
 * Implementing classes should provide logic to calculate the final amount 
 * after applying a specific discount strategy.
 * </p>
 * 
 * @author Joel
 */
public interface Discountable {

    /**
     * Applies a discount to the specified total amount.
     *
     * @param totalAmount the original total amount before discount
     * @return the final amount after applying the discount
     */
    double applyDiscount(double totalAmount);
}

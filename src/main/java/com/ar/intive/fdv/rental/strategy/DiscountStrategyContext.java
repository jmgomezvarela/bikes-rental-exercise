package com.ar.intive.fdv.rental.strategy;

public class DiscountStrategyContext {
	private IDiscount discountStrategy;
	
	public DiscountStrategyContext(IDiscount discount) {
		discountStrategy = discount;
	}

	public void setDiscountStrategy(IDiscount discountStrategy) {
		this.discountStrategy = discountStrategy;
	}
	
	public double executeStrategy(double subtotal) {
		return this.discountStrategy.executeDiscountStrategy(subtotal);
	}
}
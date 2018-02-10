package com.ar.intive.fdv.rentals;

public final class DayRental extends Rental{
	
	private static final int PRIZE = 20;
	
	public DayRental() {
		this.rentalPrize = PRIZE;
	}
	
	@Override
	public double calculateSubtotal() {
		return this.rentalTime * this.rentalPrize;
	}
}
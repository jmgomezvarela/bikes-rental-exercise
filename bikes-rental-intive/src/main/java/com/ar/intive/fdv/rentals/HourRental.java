package com.ar.intive.fdv.rentals;

public final class HourRental extends Rental{
	
	private static final int PRIZE = 5;
	
	public HourRental() {
		this.rentalPrize = PRIZE;
	}
	
	@Override
	public double calculateSubtotal() {
		return this.rentalTime * this.rentalPrize;
	}
}
package com.ar.intive.fdv.rentals;

public final class WeekRental extends Rental{
	
	private static final int PRIZE = 60;
	
	public WeekRental() {
		this.rentalPrize = PRIZE;
	}
	
	@Override
	public double calculateSubtotal() {
		return this.rentalTime * this.rentalPrize;
	}
}
package com.ar.intive.fdv.rentals;

public abstract class Rental implements IRentalSubTotal{
	protected int rentalTime;
	protected double rentalPrize;
	
	public void setRentalTime(int rentalTime) {
		this.rentalTime = rentalTime;
	}
}
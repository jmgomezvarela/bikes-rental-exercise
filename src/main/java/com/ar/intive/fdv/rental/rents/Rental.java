package com.ar.intive.fdv.rental.rents;

public abstract class Rental implements IRentalSubTotal{
	protected int rentalTime;
	protected double rentalPrize;
	
	public void setRentalTime(int rentalTime) {
		this.rentalTime = rentalTime;
	}
}
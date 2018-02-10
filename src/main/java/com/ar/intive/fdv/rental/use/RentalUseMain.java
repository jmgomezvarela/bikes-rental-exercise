package com.ar.intive.fdv.rental.use;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ar.intive.fdv.rental.factory.RentType;
import com.ar.intive.fdv.rental.factory.RentalFactory;
import com.ar.intive.fdv.rental.rents.Rental;
import com.ar.intive.fdv.rental.rents.RentalComposite;

public class RentalUseMain {
	
	 private static Logger LOGGER = LoggerFactory.getLogger(RentalUseMain.class);

	public static void main(String[] args) {
		
		LOGGER.info("starting rental bikes Main");
		
		RentalComposite rentalComposite = new RentalComposite();		
		
		Rental hourRental = RentalFactory.createRental(RentType.HOUR);
		hourRental.setRentalTime(3);
		
		Rental hourRental2 = RentalFactory.createRental(RentType.HOUR);
		hourRental2.setRentalTime(5);
		
		Rental weekRental = RentalFactory.createRental(RentType.WEEK);
		weekRental.setRentalTime(3);
		
		Rental dayRental = RentalFactory.createRental(RentType.DAY);
		dayRental.setRentalTime(1);
		
		rentalComposite.addRental(hourRental2);
		rentalComposite.addRental(hourRental);
		rentalComposite.addRental(weekRental);
		rentalComposite.addRental(dayRental);
		
		System.out.println("Total amount:" + rentalComposite.calculateSubtotal());
	}
}
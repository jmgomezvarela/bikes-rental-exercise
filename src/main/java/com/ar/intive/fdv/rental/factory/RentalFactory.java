package com.ar.intive.fdv.rental.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ar.intive.fdv.rental.exceptions.RentalFactoryException;
import com.ar.intive.fdv.rental.rents.DayRental;
import com.ar.intive.fdv.rental.rents.HourRental;
import com.ar.intive.fdv.rental.rents.Rental;
import com.ar.intive.fdv.rental.rents.WeekRental;

public final class RentalFactory {
	private static Logger LOGGER = LoggerFactory.getLogger(RentalFactory.class);
	
	public static Rental createRental(RentType rentType) {
		Rental rental = null;
		if (RentType.HOUR.equals(rentType)) {
			rental = new HourRental();
        }
        if (RentType.DAY.equals(rentType)) {
        		rental =  new DayRental();
        }
        if (RentType.WEEK.equals(rentType)) {
        		rental =  new WeekRental();
        } 
        if(rentType == null){
			 try {
					throw new RentalFactoryException();
				} catch (RentalFactoryException e) {
					LOGGER.error(e.getMessageDetailError());	
				}
		}
        return rental;
	}
}
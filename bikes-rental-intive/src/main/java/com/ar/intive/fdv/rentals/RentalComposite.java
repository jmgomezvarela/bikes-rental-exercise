package com.ar.intive.fdv.rentals;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ar.composite.bikes.rentals.factory.RentalFactory;
import com.ar.intive.fdv.rental.strategy.DiscountStrategy;
import com.ar.intive.fdv.rental.strategy.DiscountStrategyContext;
import com.ar.intive.fdv.rental.strategy.IDiscount;

public class RentalComposite implements IRentalSubTotal{
	private static Logger LOGGER = LoggerFactory.getLogger(RentalComposite.class);
	private List<IRentalSubTotal> rentals = new ArrayList<IRentalSubTotal>();
	private double total;
	
	@Override
	public double calculateSubtotal() {
		if(rentals.size()<1) {
			throw new RuntimeException("There are not rented bikes");
		}
			rentals = rentals.stream().filter(rental -> rental != null).collect(Collectors.toList());
			rentals.forEach(rental->total+=rental.calculateSubtotal());
		
			IDiscount discountStrategy = new DiscountStrategy();
			
			if(DiscountStrategy.isDiscountContext(rentals.size())) {
				DiscountStrategyContext discountStrategyContext = new DiscountStrategyContext(discountStrategy);
				total = Math.round(discountStrategyContext.executeStrategy(total));
			}
			
			LOGGER.info(MessageFormat.format("Rental total amount is: {0}", total));
			return total;
	} 
	
	public void addRental(IRentalSubTotal rental)  {
		rentals.add(rental);
	}
}
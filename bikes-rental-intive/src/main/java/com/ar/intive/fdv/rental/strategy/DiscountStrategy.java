package com.ar.intive.fdv.rental.strategy;

import java.text.MessageFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscountStrategy implements IDiscount {
	private final double DISCOUNT_FAMILY_PROMOTION = 0.7D;
	private static Logger LOGGER = LoggerFactory.getLogger(DiscountStrategy.class);

	
	public static boolean isDiscountContext(int rentalQuantity) {
		return rentalQuantity > 2 && rentalQuantity < 6;
	}

	@Override
	public double executeDiscountStrategy(double subTotal) {
		LOGGER.info(MessageFormat.format("Family rental detected. A discount of {0} % over a sub-total of {1} was applied.",DISCOUNT_FAMILY_PROMOTION,subTotal));
		return subTotal * DISCOUNT_FAMILY_PROMOTION;
	}
}
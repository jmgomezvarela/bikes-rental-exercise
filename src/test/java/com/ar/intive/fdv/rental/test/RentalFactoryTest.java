package com.ar.intive.fdv.rental.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.ar.intive.fdv.rental.factory.RentType;
import com.ar.intive.fdv.rental.factory.RentalFactory;
import com.ar.intive.fdv.rental.rents.*;

public class RentalFactoryTest {

    private Rental rental;

    @Before
    public void initial() {
        rental = null;
    }
    
    @Test
    public void testWeekRentalCreation() {
        rental = RentalFactory.createRental(RentType.WEEK);
        assertTrue(rental instanceof WeekRental);
    }

    @Test
    public void testDayRentalCreation() {
        rental = RentalFactory.createRental(RentType.DAY);
        assertTrue(rental instanceof DayRental);
    }

    @Test
    public void testHourRentalCreation() {
        rental = RentalFactory.createRental(RentType.HOUR);
        assertTrue(rental instanceof HourRental);
    }

    @Test
    public void testRentalOptionWithNullParameter() {
        rental = RentalFactory.createRental(null);
        assertEquals(rental, null);
    }
}
package com.ar.intive.rental.test.unit;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.ar.composite.bikes.rentals.factory.RentType;
import com.ar.composite.bikes.rentals.factory.RentalFactory;
import com.ar.intive.fdv.rentals.Rental;
import com.ar.intive.fdv.rentals.RentalComposite;

public class RentalTest {
	private Rental hourRental = null;
	private Rental dayRental = null;
	private Rental weekRental = null;
	private Rental  hourRental2 = null;
	private Rental dayRental2 = null;
	private Rental weekRental2 = null;
	
	private RentalComposite rentalComposite = null;
	
    @Before
    public void initial() {
    		
    		hourRental = RentalFactory.createRental(RentType.HOUR);
    		dayRental = RentalFactory.createRental(RentType.DAY);
    		weekRental = RentalFactory.createRental(RentType.WEEK);
    		
    		hourRental2 = RentalFactory.createRental(RentType.HOUR);
    		dayRental2 = RentalFactory.createRental(RentType.DAY);
    		weekRental2 = RentalFactory.createRental(RentType.WEEK);
    		
    		hourRental.setRentalTime(5);
    		dayRental.setRentalTime(3);
    		weekRental.setRentalTime(4);	
    		
    		hourRental2.setRentalTime(5);
    		dayRental2.setRentalTime(3);
    		weekRental2.setRentalTime(4);	
    		
    		rentalComposite = new RentalComposite();
    }
    
    @Test
    public void testHourRentalCalculateSubtotalImplementation() {  		
        assertEquals(hourRental.calculateSubtotal(), 25,0);
    }
    
    @Test
    public void testDayRentalCalculateSubtotalImplementation() { 		
        assertEquals(dayRental.calculateSubtotal(), 60,0);
    }
    
    @Test
    public void testWeekRentalCalculateSubtotalImplementation() {	
        assertEquals(weekRental.calculateSubtotal(), 240,0);
    }
    
 
    @Test(expected = RuntimeException.class)
    public void testNoRentingBikesBuyRequestTheTotalAmount() {
    		rentalComposite.calculateSubtotal();
    }
    
    //Bill calculation case 1: Same client rents 2 bikes in the same bill, the expected result is a 
    // total amount without a discount of 30% applied.
    @Test
    public void testTolalCalculationForBikesWithoutDiscountSameClient() { 
    		preconditionsTwoBikes();
        assertEquals(rentalComposite.calculateSubtotal(), 85,0);
    }  
    
    //Bill calculation case 2: Same client rents 3 bikes in the same bill, the expected result is a 
    // total amount with a discount of 30% applied.
    @Test
    public void testTolalCalculationForManyBikesSameClient() { 
    		preconditionsThreeBikes();
        assertEquals(rentalComposite.calculateSubtotal(), 227,0);
    }   
    
    //Bill calculation case 3: Same client rents 6 bikes in the same bill, the expected result is a 
    // total amount without a discount of 30% applied.
    @Test
    public void testTolalCalculationForMoreThanFiveBikesSameClient() { 
    		preconditionsSixBikes();
        assertEquals(rentalComposite.calculateSubtotal(), 650,0);
    }   
    
    //Bill calculation case 4: A null rent is added by mistake.
    // Expected result: The null value is removed and the total result is not affected.
    @Test
    public void testTolalCalculationWithNullRentClient() { 
    		preconditionsSixBikes();
    		rentalComposite.addRental(null);
        assertEquals(rentalComposite.calculateSubtotal(), 650,0);
    }   
    
    public void preconditionsTwoBikes() {
		rentalComposite.addRental(hourRental);
		rentalComposite.addRental(dayRental);
    }
    
    public void preconditionsThreeBikes() {
    		preconditionsTwoBikes();
		rentalComposite.addRental(weekRental);
    }
    
    public void preconditionsSixBikes() {
    		preconditionsThreeBikes();	
		rentalComposite.addRental(hourRental2);
		rentalComposite.addRental(dayRental2);
		rentalComposite.addRental(weekRental2);
    }
}
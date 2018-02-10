package com.ar.intive.fdv.rental.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.ar.intive.fdv.rental.strategy.DiscountStrategy;
import com.ar.intive.fdv.rental.strategy.DiscountStrategyContext;
import com.ar.intive.fdv.rental.strategy.IDiscount;

public class DiscountStrategyTest {
	
    private IDiscount discountStrategy = null; 
	private DiscountStrategyContext discountStrategyContext = null;
    
    @Before
    public void initial() {
    		discountStrategy = new DiscountStrategy();
    		discountStrategyContext = new DiscountStrategyContext(discountStrategy);
    }
    
    @Test
    public void testIsDiscount() {
        assertEquals(DiscountStrategy.isDiscountContext(4), true);
    }
    
    @Test
    public void testIsDiscount1() {
        assertEquals(DiscountStrategy.isDiscountContext(0), false);
    }
    
    @Test
    public void testIsDiscount2() {
        assertEquals(DiscountStrategy.isDiscountContext(15), false);
    }
    
    @Test
    public void testExecuteDiscountStrategy() {
    		double total = discountStrategy.executeDiscountStrategy(100D);
    	 	assertEquals(total,70D,0);
    }
    
    @Test
    public void testExecuteDiscountExecuteStrategy() {
    		double total = discountStrategyContext.executeStrategy(100D);		
    	 	assertEquals(total,70D,0);
    }
}
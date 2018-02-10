package com.ar.intive.fdv.exceptions;

public class RentalFactoryException extends Exception{
  	private static final long serialVersionUID = 1L;

	public RentalFactoryException(){};
    
    public String getMessageDetailError(){
        return "Rent type must be sended to RentalFactory, null value was detected";
    }
}
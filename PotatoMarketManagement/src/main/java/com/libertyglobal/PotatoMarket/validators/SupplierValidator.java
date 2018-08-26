package com.libertyglobal.PotatoMarket.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.libertyglobal.PotatoMarket.annotations.CheckSupplier;
import com.libertyglobal.PotatoMarket.enumerations.Supplier;

/**
 * Class implementing the Supplier validations for CheckSupplier annotation using Supplier enumeration.
 * 
 * @author Rabindra Rakshit
 */

public class SupplierValidator implements ConstraintValidator<CheckSupplier, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean flag=false;
		for (Supplier s : Supplier.values()) {
	        if (s.toString().equals(value)) {
	            flag=true;
	        }
	    }
		return flag;
	}

}

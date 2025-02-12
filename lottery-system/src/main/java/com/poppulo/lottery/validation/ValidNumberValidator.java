package com.poppulo.lottery.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author kalingas
 */
public class ValidNumberValidator implements ConstraintValidator<ValidNumber, Integer> {

	@Override
    public void initialize(ValidNumber number) {
    }
	
    /**
     * @param value
     * @param context
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && (value == 0 || value == 1 || value == 2);
    }
}
package com.poppulo.lottery.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * @author kalingas
 */
@Documented
@Constraint(validatedBy = ValidNumberValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNumber {
	String message() default "Number on line must be 0, 1, or 2";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.poppulo.lottery.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidNumberValidatorTests {

    private final ValidNumberValidator validator = new ValidNumberValidator();

    @Test
    void testValidNumber() {
        assertTrue(validator.isValid(0, null));
        assertTrue(validator.isValid(1, null));
        assertTrue(validator.isValid(2, null));
    }

    @Test
    void testInvalidNumber() {
        assertFalse(validator.isValid(3, null));
        assertFalse(validator.isValid(-1, null));
        assertFalse(validator.isValid(null, null));
    }
}

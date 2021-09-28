package com.company.Validators;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberValidatorTest {
    @Test
    public void testPhoneNumberPrefix() {
        PhoneNumberValidator phoneNumberValidator = new PhoneValidator("+370", "8", 11);
        String password = "861234567";
        boolean fixedNumber = phoneNumberValidator.isValidPhoneNumber(password);
        assertEquals(fixedNumber, "+37061234567");
    }

    @Test
    public void testPhoneNumberWithInvalidSymbols() {
        PhoneNumberValidator phoneNumberValidator = new PhoneValidator("+370", "8", 11);;
        boolean isValid = phoneNumberValidator.isValidPhoneNumber("8x61234567");
        assertFalse(isValid);
    }

    @Test
    public void testPhoneNumberCorrect() {
        PhoneNumberValidator phoneNumberValidator = new PhoneValidator("+370", "8", 11);;
        boolean isValid = phoneNumberValidator.isValidPhoneNumber("+37061234567");
        assertTrue(isValid);
    }
}

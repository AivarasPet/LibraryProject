package com.company.Validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidatorLithuanianImplementationTest {

    @Test
    public void testPhoneNumberPrefix() {
        PhoneNumberValidator phoneNumberValidator = new PhoneValidatorLithuanianImplementation();
        String password = "861234567";
        boolean fixedNumber = phoneNumberValidator.isValidPhoneNumber(password);
        assertEquals(fixedNumber, "+37061234567");
    }

    @Test
    public void testPhoneNumberWithInvalidSymbols() {
        PhoneNumberValidator phoneNumberValidator = new PhoneValidatorLithuanianImplementation();
        boolean isValid = phoneNumberValidator.isValidPhoneNumber("8x61234567");
        assertTrue(!isValid);
    }

    @Test
    public void testPhoneNumberCorrect() {
        PhoneNumberValidator phoneNumberValidator = new PhoneValidatorLithuanianImplementation();
        boolean isValid = phoneNumberValidator.isValidPhoneNumber("+37061234567");
        assertTrue(isValid);
    }
}
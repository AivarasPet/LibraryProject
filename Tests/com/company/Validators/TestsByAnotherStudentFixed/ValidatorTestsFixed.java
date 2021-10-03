package com.company.Validators.TestsByAnotherStudentFixed;

import com.company.Validators.EmailValidator;
import com.company.Validators.PasswordChecker;
import com.company.Validators.PhoneValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTestsFixed {

    private static PasswordChecker passwordChecker;
    private static PhoneValidator phoneValidator;
    private static EmailValidator emailValidator;

    @BeforeAll
    static void setUp(){
        passwordChecker = new PasswordChecker("!@%$#^&*");
        phoneValidator = new PhoneValidator();
        emailValidator = new EmailValidator();
    }

    @Test
    void TestPasswordLength(){
        assertTrue(passwordChecker.MeetsLengthRequirement("egegezvg", 5));
    }

    @Test
    void TestPasswordForUppercase(){
        assertTrue(passwordChecker.HasUppercaseLetters("eAgegezvg"));
    }

    @Test
    void TestPasswordForSpecialSymbols(){
        assertTrue(passwordChecker.HasSpecialSymbols("ege%gezvg"));
    }

    @Test
    void TestNumbersValidation(){
        assertTrue(phoneValidator.ConsistsOfNumbers("860545484"));
    }

    @Test
    void TestPrefixChange(){
        assertEquals("+37060545484", phoneValidator.ChangePrefix("860545484"));
    }

    @Test
    void TestOtherCountryNumberPrefixWrong(){
        assertEquals("Country code does not match", phoneValidator.ValidateOtherCountryNumbers("LV", "+37060545484"));
    }

    @Test
    void TestOtherCountryNumberLengthWrong(){
        assertEquals("The phone number length is not correct", phoneValidator.ValidateOtherCountryNumbers("LV", "+37160545484841"));
    }

    @Test
    void TestOtherCountryNumberPrefixCorrect(){
        assertEquals("The number's prefix and length are correct", phoneValidator.ValidateOtherCountryNumbers("LT", "+37060545484"));
    }


    @Test
    void TestNumberLengthValidationByCountryCode(){
        assertTrue(phoneValidator.ValidateNumberLenghtByCountryCode("LT", "+37060545484"));
    }

    @Test
    void TestAtSymbol(){
        assertTrue(emailValidator.ContainsAtSymbol("r.bagdonas@gmail.com"));
    }

    @Test
    void TestForbiddenSymbols(){
        assertFalse(emailValidator.ContainsForbiddenSymbols("rokas:bagdonas@gmail.com"));
    }

    @Test
    void TestEmailsDomainName(){
        assertTrue(emailValidator.HasGoodDomainName("rokas.bagdonas@mif.stud.vu.lt"));
    }

    @Test
    void TestEmailsTLD(){
        assertTrue(emailValidator.HasGoodTLD("rokas.bagdonas@mif.stud.vu.lt"));
    }

    @AfterEach
    void tearDown(){

    }
}

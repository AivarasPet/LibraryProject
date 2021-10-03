# LibraryProject
Programų sistemų projektavimas

ValidatorTests.java - a script where the student originally placed his tests.
ValidatorTestsFixed.java - a script where I fixed up the fallacies of tests made by another student.

Expected values of some of the tests did not match their names. For instance:
assertTrue(passwordChecker.HasUppercaseLetters("egegezvg")); 
The test should return false, as argument does not contain UpperCase letters. There were other instances of something like this.

There were also an instance where a service was supposed return a confirmation Strings on correct phone number. However, it is physically impossible to for these 2 tests to coexist 
as they confirm the same thing:
    @Test
    void TestOtherCountryNumberPrefixCorrect(){
        assertEquals("The number's prefix is correct", phoneValidator.ValidateOtherCountryNumbers("LT", "+37060545484"));
    }

    @Test
    void TestOtherCountryNumberLengthCorrect(){
        assertEquals("The number's length is correct", phoneValidator.ValidateOtherCountryNumbers("LT", "+37060545484"));
    }


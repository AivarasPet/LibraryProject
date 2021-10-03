package com.company.Validators;

import java.util.Set;
import java.util.stream.Collectors;

public class PasswordChecker {

    private String specialSymbols;

    public PasswordChecker(String specialSymbols) {
        this.specialSymbols = specialSymbols;
    }

    public boolean MeetsLengthRequirement(String password, int requiredCharacterCount) {
        if(password.length() < requiredCharacterCount) {
            return false;
        }
        return true;
    }

    public boolean HasUppercaseLetters(String password) {
        char ch;
        for(int i=0; i < password.length(); i++) {
            ch = password.charAt(i);
            if(ch <= 'Z' && ch >= 'A') {
                return true;
            }
        }
        return false;
    }

    public boolean HasSpecialSymbols(String password) {
        // this string should have been a parameter
        Set<Character> charsSet = specialSymbols.chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());

        char ch;
        for(int i=0; i < password.length(); i++) {
            ch = password.charAt(i);
            if(charsSet.contains(ch)) {
                return true;
            }
        }
        return false;
    }

}

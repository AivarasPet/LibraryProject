package CredentialValidatorLibraty;

public class CountryPhoneNumber {

    private String CountryCode;
    private String PhoneNumberPrefix;
    private int PhoneNumberLength;

    public CountryPhoneNumber(String countryCode, String phoneNumberPrefix, int phoneNumberLength) {
        CountryCode = countryCode;
        PhoneNumberPrefix = phoneNumberPrefix;
        PhoneNumberLength = phoneNumberLength;
    }

    public String getCountryCode() {
        return CountryCode;
    }


    public String getPhoneNumberPrefix() {
        return PhoneNumberPrefix;
    }

    public int getPhoneNumberLength() {
        return PhoneNumberLength;
    }
}

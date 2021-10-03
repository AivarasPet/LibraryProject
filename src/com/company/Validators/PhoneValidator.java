package CredentialValidatorLibraty;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class PhoneValidator {

    public boolean ConsistsOfNumbers(String phoneNumber) {
        char ch;
        for (int i = 0; i < phoneNumber.length(); i++) {
            ch = phoneNumber.charAt(i);
            if(ch <  '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    public String ChangePrefix(String phoneNumber) {
        if(phoneNumber.charAt(0) != '8') return phoneNumber;

        phoneNumber = "+370" + phoneNumber.substring(1);
        return phoneNumber;
    }

   public String ValidateOtherCountryNumbers(String countryCode, String phoneNumber) {
          CountryPhoneNumberRepository countryPhoneNumberRepository = new CountryPhoneNumberRepository();
          Map<String, CountryPhoneNumber> phoneNumberMap = countryPhoneNumberRepository.getCountryPhoneNumbersMap();
          if(phoneNumberMap.containsKey(countryCode) == false) return "Such country code does not exist";

          String prefix = phoneNumberMap.get(countryCode).getPhoneNumberPrefix();
          if(phoneNumber.startsWith(prefix) == false) {
              return "Country code does not match";
          }

          if(phoneNumberMap.get(countryCode).getPhoneNumberLength() > phoneNumber.length()) {
              return  "The phone number is too long";
          }


          return "The number's prefix is correct";

   }

   public boolean ValidateNumberLenghtByCountryCode(String countryCode, String phoneNumber) {
       CountryPhoneNumberRepository countryPhoneNumberRepository = new CountryPhoneNumberRepository();
       Map<String, CountryPhoneNumber> phoneNumberMap = countryPhoneNumberRepository.getCountryPhoneNumbersMap();
       if(phoneNumberMap.containsKey(countryCode) == false) return false;

       if(phoneNumberMap.get(countryCode).getPhoneNumberLength() == phoneNumber.length()) return true;

        return false;
   }


}

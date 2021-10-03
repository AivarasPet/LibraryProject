package CredentialValidatorLibraty;

import java.util.HashMap;
import java.util.Map;

public class CountryPhoneNumberRepository {

    public Map<String, CountryPhoneNumber> getCountryPhoneNumbersMap() {
        Map<String, CountryPhoneNumber> phoneNumberMap = new HashMap<>();

        CountryPhoneNumber lithuanianNumber = new CountryPhoneNumber("LT", "+370", 12);
        phoneNumberMap.put(lithuanianNumber.getCountryCode(), lithuanianNumber);

        return phoneNumberMap;
    }
}

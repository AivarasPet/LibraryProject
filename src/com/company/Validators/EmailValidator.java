package com.company.Validators;

import com.company.Repositories.EmailDomainRepository;
import com.company.Repositories.TldRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class EmailValidator {

    private String forbiddenSymbols = ";][";
    public boolean ContainsAtSymbol(String email) {
        char ch;
        for (int i = 0; i < email.length(); i++) {
            ch = email.charAt(i);
            if(ch == '@') return true;
        }
        return false;
    }

    public boolean ContainsForbiddenSymbols(String email) {
        Set<Character> charsSet = forbiddenSymbols.chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());

        for (int i = 0; i < email.length(); i++) {
            if(charsSet.contains(email.charAt(i))) return true;
        }
        return false;
    }

    public boolean HasGoodDomainName(String email) {
        EmailDomainRepository emailDomainRepository = new EmailDomainRepository();
        Set<String> domains = emailDomainRepository.getValidEmailDomains();
        if(domains.contains(email.substring(email.indexOf('@')+1)))
            return true;
        return false;
    }

    public boolean HasGoodTLD(String email) {
        TldRepository tldRepository = new TldRepository();
        Set<String> availableTlds = tldRepository.getAvailableTlds();
        String endOfEmail = email.substring(email.lastIndexOf('.'));
        if(availableTlds.contains(endOfEmail))
            return true;
        return false;
    }

}

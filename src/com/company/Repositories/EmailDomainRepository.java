package Repositories;

import java.util.HashSet;
import java.util.Set;

public class EmailDomainRepository {
    public Set<String> getValidEmailDomains() {
        Set<String> emails = new HashSet<>();
        emails.add("mif.vu.lt");
        emails.add("mif.stud.vu.lt");
        emails.add("gmail.com");
        emails.add("outlook.com");
        return emails;
    }
}

package Repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TldRepository {
    public Set<String> getAvailableTlds() {
        Set<String> tlds = new HashSet<>();
        tlds.add(".com");
        tlds.add(".lt");
        tlds.add(".net");
        return tlds;
    }
}

package de.atruvia.service.internal;


import de.atruvia.service.BlacklistService;
import de.atruvia.service.model.Person;

import java.util.List;


public class BlacklistServiceImpl implements BlacklistService {

    private static final List<String> ANTIPATHEN = List.of("Attila", "Peter");
    @Override
    public boolean isBlacklisted(final Person possibleBlacklisted) {
        return ANTIPATHEN.contains(possibleBlacklisted.getVorname());
    }
}

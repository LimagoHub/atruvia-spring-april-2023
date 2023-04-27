package de.atruvia.service;


import de.atruvia.service.model.Person;

public interface BlacklistService {

    boolean isBlacklisted(Person possibleBlacklisted);
}

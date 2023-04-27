package de.atruvia.service;


import de.atruvia.service.model.Person;

import java.util.Optional;

public interface PersonenService {

    void anlegen(Person person) throws PersonenServiceException;

    void aendern(Person person) throws PersonenServiceException;
    boolean loesche(String id) throws PersonenServiceException;

    Optional<Person> findeNachId(String id) throws PersonenServiceException;

    Iterable<Person> findeAlle() throws PersonenServiceException;
}

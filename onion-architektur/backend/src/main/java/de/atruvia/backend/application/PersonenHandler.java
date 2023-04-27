package de.atruvia.backend.application;


import de.atruvia.service.PersonenService;
import de.atruvia.service.PersonenServiceException;
import de.atruvia.service.model.Person;
import org.springframework.stereotype.Service;


public interface PersonenHandler {

    void handleAnlegen(Person person) throws PersonenServiceException;
    void handleAendern(Person person) throws PersonenServiceException;

    boolean handleDelete(String id) throws PersonenServiceException;
}

package de.atruvia.service.internal;


import de.atruvia.service.BlacklistService;
import de.atruvia.service.PersonenService;
import de.atruvia.service.PersonenServiceException;
import de.atruvia.service.model.Person;
import de.atruvia.service.repository.PersonenRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PersonenServiceImpl implements PersonenService {


    private final PersonenRepository repository;

    private final BlacklistService blacklistService;

    /*
        person == null -> PSE
        vorname == null -> PSE
        VORNAME zu kurz -> PSE
        nachname == null -> PSE
        nachNAME zu kurz -> PSE

        Attila -> PSE

        wenn exception im repo -> PSE

        happy day -> person an repo weiterreichen

     */
    @Override
    public void anlegen(final Person person) throws PersonenServiceException {
        pruefenUndSpeichern(person);
    }

    @Override
    public void aendern(final Person person) throws PersonenServiceException {
        pruefenUndSpeichern(person);
    }


    private void pruefenUndSpeichern(final Person person) throws PersonenServiceException {
        try {
            if (person == null)
                throw new PersonenServiceException("Person darf nicht null sein.");

            if (person.getVorname() == null || person.getVorname().length() < 2)
                throw new PersonenServiceException("Vorname zu kurz.");

            if (person.getNachname() == null || person.getNachname().length() < 2)
                throw new PersonenServiceException("Nachname zu kurz.");

            if (blacklistService.isBlacklisted(person))
                throw new PersonenServiceException("Unerwuenschte Person");

            repository.save(person);
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Fehler beim Speichern", e);
        }
    }


    @Override
    public boolean loesche(String id) throws PersonenServiceException {
        try {
            if(repository.existsById(id)) {
                repository.deleteById(id);
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            throw new PersonenServiceException(e);
        }
    }

    // Select * from customers with ur

    @Override
    public Optional<Person> findeNachId(String id) throws PersonenServiceException {
        try {
            return repository.findById(id);
        } catch (RuntimeException e) {
            throw new PersonenServiceException(e);
        }
    }

    @Override
    public Iterable<Person> findeAlle() throws PersonenServiceException {
        try {
            return repository.findAll();
        } catch (RuntimeException e) {
            throw new PersonenServiceException(e);
        }
    }
}

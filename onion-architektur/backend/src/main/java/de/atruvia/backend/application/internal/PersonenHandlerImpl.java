package de.atruvia.backend.application.internal;

import de.atruvia.backend.application.PersonenHandler;
import de.atruvia.service.PersonenService;
import de.atruvia.service.PersonenServiceException;
import de.atruvia.service.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = PersonenServiceException.class)
@RequiredArgsConstructor
public class PersonenHandlerImpl implements PersonenHandler {

    private final PersonenService personenService;
    @Override
    public void handleAnlegen(final Person person) throws PersonenServiceException {
        try {
            personenService.anlegen(person);
            // Success Event
        } catch (PersonenServiceException e) {
            // Failure Event
            throw e;
        }
    }

    @Override
    public void handleAendern(final Person person) throws PersonenServiceException {
        personenService.aendern(person);
    }

    @Override
    public boolean handleDelete(final String id) throws PersonenServiceException {
        return personenService.loesche(id);
    }
}

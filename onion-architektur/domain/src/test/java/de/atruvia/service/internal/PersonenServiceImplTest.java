package de.atruvia.service.internal;

import de.atruvia.service.PersonenServiceException;
import de.atruvia.service.model.Person;
import de.atruvia.service.repository.PersonenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class PersonenServiceImplTest {

    @InjectMocks
    private PersonenServiceImpl objectUnderTest;

    @Mock
    private PersonenRepository personenRepositoryMock;



    @Mock
    private List<String> antipathenMock;
    @Test
    void anlegen_personIsNull_throwsPersonenServiceException() throws Exception{
        PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.anlegen(null));
        assertEquals("Person darf nicht null sein.", ex.getMessage());

    }

    @Test
    void anlegen_vornameIstNull_throwsPersonenServiceException() throws Exception{
        Person invalidPerson = Person.builder().id(UUID.randomUUID().toString()).vorname(null).nachname("Doe").build();
        PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.anlegen(invalidPerson));
        assertEquals("Vorname zu kurz.", ex.getMessage());

    }

}
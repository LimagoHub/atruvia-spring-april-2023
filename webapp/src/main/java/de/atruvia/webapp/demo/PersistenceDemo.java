package de.atruvia.webapp.demo;

import de.atruvia.webapp.persistence.entity.PersonEntity;
import de.atruvia.webapp.persistence.repository.PersonenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class PersistenceDemo {

    private final PersonenRepository repo;

    @PostConstruct
    public void init() {
        //PersonEntity personEntity = PersonEntity.builder().id("2").vorname("John").nachname("Rambo").build();

        for(var person : repo.bcd("Wayne")) {
            System.out.println(person);
        }
    }
}

package de.atruvia.service.repository;

import de.atruvia.service.model.Person;

import java.util.Optional;

public interface PersonenRepository {

    void save (Person person);
    boolean existsById(String id);
    Optional<Person> findById(String id);
    Iterable<Person> findAll();
    void deleteById(String id);
}

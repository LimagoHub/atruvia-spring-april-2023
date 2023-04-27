package de.atruvia.backend.adapter.mapper;


import de.atruvia.backend.adapter.repository.raw.entity.PersonEntity;
import de.atruvia.service.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person convert(PersonEntity entity);
    PersonEntity convert(Person person);

    Iterable<Person> convert(Iterable<PersonEntity> entities);
}

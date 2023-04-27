package de.atruvia.backend.adapter.mapper;


import de.atruvia.backend.adapter.dto.PersonDto;
import de.atruvia.service.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonDtoMapper {
    PersonDto convert(Person person);
    Person convert(PersonDto dto);

    Iterable<PersonDto> convert(Iterable<Person> personen);
}

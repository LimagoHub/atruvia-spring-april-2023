package de.atruvia.backend.adapter.repository;

import de.atruvia.backend.adapter.mapper.PersonMapper;
import de.atruvia.backend.adapter.repository.raw.PersonenRepositoryRaw;
import de.atruvia.service.model.Person;
import de.atruvia.service.repository.PersonenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersonenRepositoryImpl implements PersonenRepository {


    private final PersonenRepositoryRaw rawRepo;
    private final PersonMapper mapper;

    @Override
    public void save(final Person person) {
        rawRepo.save(mapper.convert(person));
    }

    @Override
    public boolean existsById(final String s) {
        return rawRepo.existsById(s);
    }

    @Override
    public Optional<Person> findById(final String s) {
        return rawRepo.findById(s).map(mapper::convert);
    }

    @Override
    public Iterable<Person> findAll() {
        return mapper.convert(rawRepo.findAll());
    }

    @Override
    public void deleteById(final String s) {
        rawRepo.deleteById(s);
    }
}

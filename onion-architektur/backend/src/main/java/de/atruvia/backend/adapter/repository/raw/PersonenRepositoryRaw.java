package de.atruvia.backend.adapter.repository.raw;

import de.atruvia.backend.adapter.repository.raw.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonenRepositoryRaw extends CrudRepository<PersonEntity, String> {
}

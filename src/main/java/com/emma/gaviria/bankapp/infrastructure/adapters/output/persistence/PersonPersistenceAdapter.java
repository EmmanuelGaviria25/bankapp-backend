package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence;

import com.emma.gaviria.bankapp.domain.exception.PersonNotFound;
import com.emma.gaviria.bankapp.domain.model.Person;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper.PersonPersistenceMapper;
import com.emma.gaviria.bankapp.application.ports.output.PersonOutputPort;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.PersonEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@RequiredArgsConstructor
public class PersonPersistenceAdapter implements PersonOutputPort {

    private final PersonRepository repository;

    private final PersonPersistenceMapper mapper;

    @Override
    public Person savePerson(Person person) {
        PersonEntity personEntity = mapper.toPersonEntity(person);
        personEntity = repository.save(personEntity);
        return mapper.toPerson(personEntity);
    }

    @Override
    public Person updatePerson(Person person) {
        PersonEntity personEntity = mapper.toPersonEntity(person);
        personEntity = repository.save(personEntity);
        return mapper.toPerson(personEntity);
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        Optional<PersonEntity> personEntity = repository.findById(id);

        if(personEntity.isEmpty()) {
            return Optional.empty();
        }

        Person person = mapper.toPerson(personEntity.get());
        return Optional.of(person);
    }

    @Override
    public void deletePersonById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new PersonNotFound("Person not found with id " + id);
        }
    }

}

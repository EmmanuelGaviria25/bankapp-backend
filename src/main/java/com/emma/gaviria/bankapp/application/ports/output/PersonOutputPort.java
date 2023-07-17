package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.model.Person;

import java.util.Optional;

public interface PersonOutputPort {

    Person savePerson(Person person);

    Person updatePerson(Person person);

    Optional<Person> getPersonById(Long id);

    void deletePersonById(Long id);
}

package com.emma.gaviria.bankapp.domain.service;

import com.emma.gaviria.bankapp.application.ports.input.person.DeletePersonUseCase;
import com.emma.gaviria.bankapp.application.ports.input.person.UpdatePersonUseCase;
import com.emma.gaviria.bankapp.application.ports.output.PersonEventPublisher;
import com.emma.gaviria.bankapp.domain.event.person.PersonCreatedEvent;
import com.emma.gaviria.bankapp.application.ports.input.person.CreatePersonUseCase;
import com.emma.gaviria.bankapp.application.ports.input.person.GetPersonUseCase;
import com.emma.gaviria.bankapp.application.ports.output.PersonOutputPort;
import com.emma.gaviria.bankapp.domain.event.person.PersonUpdatedEvent;
import com.emma.gaviria.bankapp.domain.exception.PersonNotFound;
import com.emma.gaviria.bankapp.domain.model.Person;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonService implements CreatePersonUseCase, GetPersonUseCase, UpdatePersonUseCase, DeletePersonUseCase {

    private final PersonOutputPort personOutputPort;

    private final PersonEventPublisher personEventPublisher;

    @Override
    public Person createPerson(Person person) {
        person = personOutputPort.savePerson(person);
        personEventPublisher.publishPersonCreatedEvent(new PersonCreatedEvent(person.getId()));
        return person;
    }

    @Override
    public Person getPersonById(Long id) {
        return personOutputPort.getPersonById(id).orElseThrow(() -> new PersonNotFound("Person not found with id " + id));
    }

    @Override
    public Person updatePerson(Person person) {
        person = personOutputPort.updatePerson(person);
        personEventPublisher.publishPersonUpdatedEvent(new PersonUpdatedEvent(person.getId()));
        return person;
    }

    @Override
    public void deletePersonById(Long id) {
        personOutputPort.deletePersonById(id);
    }
}

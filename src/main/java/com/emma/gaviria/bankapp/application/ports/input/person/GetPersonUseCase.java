package com.emma.gaviria.bankapp.application.ports.input.person;

import com.emma.gaviria.bankapp.domain.model.Person;

public interface GetPersonUseCase {

    Person getPersonById(Long id);

}

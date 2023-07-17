package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest;

import com.emma.gaviria.bankapp.application.ports.input.person.DeletePersonUseCase;
import com.emma.gaviria.bankapp.application.ports.input.person.UpdatePersonUseCase;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.person.PersonCreateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.person.PersonUpdateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.person.PersonResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.person.PersonQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper.PersonRestMapper;
import com.emma.gaviria.bankapp.application.ports.input.person.CreatePersonUseCase;
import com.emma.gaviria.bankapp.application.ports.input.person.GetPersonUseCase;
import com.emma.gaviria.bankapp.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class PersonRestAdapter {

    private final CreatePersonUseCase createPersonUseCase;

    private final UpdatePersonUseCase updatePersonUseCase;

    private final GetPersonUseCase getPersonUseCase;

    private final DeletePersonUseCase deletePersonUseCase;

    private final PersonRestMapper personRestMapper;

    @PostMapping(value = "/persons")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody @Valid PersonCreateRequest personCreateRequest) {
        Person person = personRestMapper.toPersonCreate(personCreateRequest);

        person = createPersonUseCase.createPerson(person);

        return new ResponseEntity<>(personRestMapper.toPersonCreateResponse(person), HttpStatus.CREATED);
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<PersonQueryResponse> getPerson(@PathVariable Long id) {
        Person person = getPersonUseCase.getPersonById(id);
        return new ResponseEntity<>(personRestMapper.toPersonQueryResponse(person), HttpStatus.OK);
    }

    @PutMapping(value = "/persons")
    public ResponseEntity<PersonResponse> updatePerson(@RequestBody @Valid PersonUpdateRequest personUpdateRequest) {
        Person person = personRestMapper.toPersonUpdate(personUpdateRequest);

        person = updatePersonUseCase.updatePerson(person);

        return new ResponseEntity<>(personRestMapper.toPersonCreateResponse(person), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/persons/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        deletePersonUseCase.deletePersonById(id);
        return new ResponseEntity<>("Person deleted", HttpStatus.OK);
    }

}

package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper;

import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.person.PersonUpdateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.person.PersonResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.person.PersonQueryResponse;
import com.emma.gaviria.bankapp.domain.model.Person;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.person.PersonCreateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface PersonRestMapper {

    Person toPersonCreate(PersonCreateRequest personCreateRequest);

    Person toPersonUpdate(PersonUpdateRequest personUpdateRequest);

    PersonResponse toPersonCreateResponse(Person person);

    PersonQueryResponse toPersonQueryResponse(Person person);

}

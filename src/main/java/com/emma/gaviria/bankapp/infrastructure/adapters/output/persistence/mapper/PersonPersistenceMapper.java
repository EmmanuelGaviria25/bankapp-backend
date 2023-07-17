package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper;

import com.emma.gaviria.bankapp.domain.model.Person;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PersonPersistenceMapper {

    PersonEntity toPersonEntity(Person person);

    Person toPerson(PersonEntity personEntity);

}

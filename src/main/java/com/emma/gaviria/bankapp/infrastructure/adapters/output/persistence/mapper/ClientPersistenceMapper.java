package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper;

import com.emma.gaviria.bankapp.domain.model.Client;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ClientPersistenceMapper {

    ClientEntity toClientEntity(Client client);

    Client toClient(ClientEntity clientEntity);

}

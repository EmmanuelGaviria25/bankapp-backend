package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper;

import com.emma.gaviria.bankapp.domain.model.Client;
import com.emma.gaviria.bankapp.domain.model.Person;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.client.ClientCreateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.client.ClientUpdateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client.ClientQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientRestMapper {

    Client toClientCreate(ClientCreateRequest clientCreateRequest);

    Client toClientUpdate(ClientUpdateRequest clientUpdateRequest);

    ClientResponse toClientCreateResponse(Client client);

    ClientQueryResponse toClientQueryResponse(Client client);


}

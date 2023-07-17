package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest;

import com.emma.gaviria.bankapp.application.ports.input.client.CreateClientUseCase;
import com.emma.gaviria.bankapp.application.ports.input.client.DeleteClientUseCase;
import com.emma.gaviria.bankapp.application.ports.input.client.GetClientUseCase;
import com.emma.gaviria.bankapp.application.ports.input.client.UpdateClientUseCase;
import com.emma.gaviria.bankapp.domain.model.Client;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.client.ClientCreateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.client.ClientUpdateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client.ClientQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client.ClientResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.person.PersonQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper.ClientRestMapper;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper.PersonRestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Log4j2
public class ClientRestAdapter {

    private final CreateClientUseCase createClientUseCase;

    private final UpdateClientUseCase updateClientUseCase;

    private final GetClientUseCase getClientUseCase;

    private final DeleteClientUseCase deleteClientUseCase;

    private final ClientRestMapper clientRestMapper;

    @PostMapping(value = "/clients")
    public ResponseEntity<ClientResponse> createClient(@RequestBody @Valid ClientCreateRequest clientCreateRequest) {
        Client client = clientRestMapper.toClientCreate(clientCreateRequest);

        client = createClientUseCase.createClient(client);

        return new ResponseEntity<>(clientRestMapper.toClientCreateResponse(client), HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<ClientQueryResponse> getClient(@PathVariable Long id) {
        Client client = getClientUseCase.getClientById(id);
        ClientQueryResponse clientQueryResponse = clientRestMapper.toClientQueryResponse(client);
        return new ResponseEntity<>(clientQueryResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/clients")
    public ResponseEntity<ClientResponse> updateClient(@RequestBody @Valid ClientUpdateRequest clientUpdateRequest) {
        Client client = clientRestMapper.toClientUpdate(clientUpdateRequest);
        client = updateClientUseCase.updateClient(client);
        return new ResponseEntity<>(clientRestMapper.toClientCreateResponse(client), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        deleteClientUseCase.deleteClientById(id);
        return new ResponseEntity<>("Client deleted", HttpStatus.OK);
    }

}

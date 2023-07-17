package com.emma.gaviria.bankapp.domain.service;

import com.emma.gaviria.bankapp.application.ports.input.client.CreateClientUseCase;
import com.emma.gaviria.bankapp.application.ports.input.client.DeleteClientUseCase;
import com.emma.gaviria.bankapp.application.ports.input.client.GetClientUseCase;
import com.emma.gaviria.bankapp.application.ports.input.client.UpdateClientUseCase;
import com.emma.gaviria.bankapp.application.ports.output.ClientEventPublisher;
import com.emma.gaviria.bankapp.application.ports.output.ClientOutputPort;
import com.emma.gaviria.bankapp.application.ports.output.PersonOutputPort;
import com.emma.gaviria.bankapp.domain.event.client.ClientCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.client.ClientUpdatedEvent;
import com.emma.gaviria.bankapp.domain.exception.ClientNotFound;
import com.emma.gaviria.bankapp.domain.exception.PersonNotFound;
import com.emma.gaviria.bankapp.domain.model.Client;
import com.emma.gaviria.bankapp.domain.model.Person;
import lombok.AllArgsConstructor;

import java.util.function.Function;

@AllArgsConstructor
public class ClientService implements CreateClientUseCase, GetClientUseCase, UpdateClientUseCase, DeleteClientUseCase {

    private final ClientOutputPort clientOutputPort;

    private final ClientEventPublisher clientEventPublisher;

    private final PersonOutputPort personOutputPort;

    @Override
    public Client createClient(Client client) {
        Client finalClient = client;
        Person person = personOutputPort.getPersonById(client.getPersonId())
                .orElseThrow(() -> new PersonNotFound("Person not found with id " + finalClient.getPersonId()));

        client.setPerson(person);
        client = clientOutputPort.saveClient(client);
        clientEventPublisher.publishClientCreatedEvent(new ClientCreatedEvent(client.getId()));
        return client;
    }

    @Override
    public Client getClientById(Long id) {
        Client client = clientOutputPort.getClientById(id)
                .orElseThrow(() -> new ClientNotFound("Client not found with id " + id));

        return client;
    }

    @Override
    public Client updateClient(Client client) {
        Client finalClient = client;
        Person person = personOutputPort.getPersonById(client.getPersonId())
                .orElseThrow(() -> new PersonNotFound("Person not found with id " + finalClient.getPersonId()));

        client.setPerson(person);
        client = clientOutputPort.updateClient(client);
        clientEventPublisher.publishClientUpdatedEvent(new ClientUpdatedEvent(client.getId()));
        return client;
    }

    @Override
    public void deleteClientById(Long id) {
        clientOutputPort.deleteClientById(id);
    }
}

package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.model.Client;

import java.util.Optional;

public interface ClientOutputPort {

    Client saveClient(Client client);

    Client updateClient(Client client);

    Optional<Client> getClientById(Long id);

    void deleteClientById(Long id);
}

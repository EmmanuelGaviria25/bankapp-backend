package com.emma.gaviria.bankapp.application.ports.input.client;

import com.emma.gaviria.bankapp.domain.model.Client;

public interface CreateClientUseCase {

    Client createClient(Client client);

}

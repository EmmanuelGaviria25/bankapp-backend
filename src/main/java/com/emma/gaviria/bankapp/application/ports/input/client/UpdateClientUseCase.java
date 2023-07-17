package com.emma.gaviria.bankapp.application.ports.input.client;

import com.emma.gaviria.bankapp.domain.model.Client;

public interface UpdateClientUseCase {

    Client updateClient(Client client);

}

package com.emma.gaviria.bankapp.application.ports.input.client;

import com.emma.gaviria.bankapp.domain.model.Client;

public interface GetClientUseCase {

    Client getClientById(Long id);

}

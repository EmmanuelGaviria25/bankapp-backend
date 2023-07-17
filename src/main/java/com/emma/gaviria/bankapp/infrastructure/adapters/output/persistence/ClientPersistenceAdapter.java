package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence;

import com.emma.gaviria.bankapp.application.ports.output.ClientOutputPort;
import com.emma.gaviria.bankapp.domain.exception.ClientNotFound;
import com.emma.gaviria.bankapp.domain.model.Client;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.ClientEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper.ClientPersistenceMapper;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper.ClientPersistenceMapper;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.ClientRepository;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientOutputPort {

    private final ClientRepository repository;

    private final ClientPersistenceMapper mapper;

    @Override
    public Client saveClient(Client client) {
        ClientEntity clientEntity = mapper.toClientEntity(client);
        clientEntity = repository.save(clientEntity);
        return mapper.toClient(clientEntity);
    }

    @Override
    public Client updateClient(Client client) {
        ClientEntity clientEntity = mapper.toClientEntity(client);
        clientEntity = repository.save(clientEntity);
        return mapper.toClient(clientEntity);
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        Optional<ClientEntity> clientEntity = repository.findById(id);

        if(clientEntity.isEmpty()) {
            return Optional.empty();
        }

        Client client = mapper.toClient(clientEntity.get());
        return Optional.of(client);
    }

    @Override
    public void deleteClientById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ClientNotFound("Client not found with id " + id);
        }
    }

}

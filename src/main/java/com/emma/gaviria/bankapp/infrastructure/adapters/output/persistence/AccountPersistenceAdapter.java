package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence;

import com.emma.gaviria.bankapp.application.ports.output.AccountOutputPort;
import com.emma.gaviria.bankapp.domain.exception.AccountNotFound;
import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account.AccountStatementRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountStatementResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.AccountEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper.AccountPersistenceMapper;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@RequiredArgsConstructor
public class AccountPersistenceAdapter implements AccountOutputPort {

    private final AccountRepository repository;

    private final AccountPersistenceMapper mapper;

    @Override
    public Account saveAccount(Account account) {
        AccountEntity accountEntity = mapper.toAccountEntity(account);
        accountEntity = repository.save(accountEntity);
        return mapper.toAccount(accountEntity);
    }

    @Override
    public Account updateAccount(Account account) {
        AccountEntity accountEntity = mapper.toAccountEntity(account);
        accountEntity = repository.save(accountEntity);
        return mapper.toAccount(accountEntity);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        Optional<AccountEntity> accountEntity = repository.findById(id);

        if(accountEntity.isEmpty()) {
            return Optional.empty();
        }

        Account account = mapper.toAccount(accountEntity.get());
        return Optional.of(account);
    }

    @Override
    public void deleteAccountById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new AccountNotFound("Account not found with id " + id);
        }
    }

    @Override
    public Optional<Account> getAccountActiveById(Long id) {
        Optional<AccountEntity> accountEntity = repository.findByIdByStatusActive(id);

        if(accountEntity.isEmpty()) {
            return Optional.empty();
        }

        Account account = mapper.toAccount(accountEntity.get());
        return Optional.of(account);
    }
}

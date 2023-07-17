package com.emma.gaviria.bankapp.domain.service;

import com.emma.gaviria.bankapp.application.ports.input.account.CreateAccountUseCase;
import com.emma.gaviria.bankapp.application.ports.input.account.DeleteAccountUseCase;
import com.emma.gaviria.bankapp.application.ports.input.account.GetAccountUseCase;
import com.emma.gaviria.bankapp.application.ports.input.account.UpdateAccountUseCase;
import com.emma.gaviria.bankapp.application.ports.output.AccountEventPublisher;
import com.emma.gaviria.bankapp.application.ports.output.AccountOutputPort;
import com.emma.gaviria.bankapp.application.ports.output.ClientOutputPort;
import com.emma.gaviria.bankapp.application.ports.output.PersonOutputPort;
import com.emma.gaviria.bankapp.domain.event.account.AccountCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.account.AccountUpdatedEvent;
import com.emma.gaviria.bankapp.domain.exception.AccountNotFound;
import com.emma.gaviria.bankapp.domain.exception.PersonNotFound;
import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.domain.model.Client;
import com.emma.gaviria.bankapp.domain.model.Person;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountService implements CreateAccountUseCase, GetAccountUseCase, UpdateAccountUseCase, DeleteAccountUseCase {

    private final AccountOutputPort accountOutputPort;

    private final AccountEventPublisher accountEventPublisher;

    private final ClientOutputPort clientOutputPort;

    @Override
    public Account createAccount(Account account) {
        Account finalAccount = account;
        Client client = clientOutputPort.getClientById(account.getClientId())
                .orElseThrow(() -> new PersonNotFound("Client not found with id " + finalAccount.getClientId()));

        account.setClient(client);
        account = accountOutputPort.saveAccount(account);
        accountEventPublisher.publishAccountCreatedEvent(new AccountCreatedEvent(account.getId()));
        return account;
    }

    @Override
    public Account getAccountById(Long id) {
        Account account = accountOutputPort.getAccountById(id)
                .orElseThrow(() -> new AccountNotFound("Account not found with id " + id));

        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        Account finalAccount = account;
        Client client = clientOutputPort.getClientById(account.getClientId())
                .orElseThrow(() -> new PersonNotFound("Client not found with id " + finalAccount.getClientId()));

        account.setClient(client);
        account = accountOutputPort.updateAccount(account);
        accountEventPublisher.publishAccountUpdatedEvent(new AccountUpdatedEvent(account.getId()));
        return account;
    }

    @Override
    public void deleteAccountById(Long id) {
        accountOutputPort.deleteAccountById(id);
    }
}

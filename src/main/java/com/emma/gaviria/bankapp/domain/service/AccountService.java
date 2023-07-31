package com.emma.gaviria.bankapp.domain.service;

import com.emma.gaviria.bankapp.application.ports.input.account.*;
import com.emma.gaviria.bankapp.application.ports.output.AccountEventPublisher;
import com.emma.gaviria.bankapp.application.ports.output.AccountOutputPort;
import com.emma.gaviria.bankapp.application.ports.output.ClientOutputPort;
import com.emma.gaviria.bankapp.application.ports.output.MovementOutputPort;
import com.emma.gaviria.bankapp.domain.event.account.AccountCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.account.AccountUpdatedEvent;
import com.emma.gaviria.bankapp.domain.exception.AccountNotFound;
import com.emma.gaviria.bankapp.domain.exception.PersonNotFound;
import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.domain.model.Client;
import com.emma.gaviria.bankapp.domain.model.Movement;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account.AccountStatementRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountStatementResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper.AccountRestMapper;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@AllArgsConstructor
public class AccountService implements CreateAccountUseCase, GetAccountUseCase, UpdateAccountUseCase, DeleteAccountUseCase, ReportAccountStatementUseCase {

    private final AccountOutputPort accountOutputPort;

    private final AccountEventPublisher accountEventPublisher;

    private final ClientOutputPort clientOutputPort;

    private final MovementOutputPort movementOutputPort;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

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

    @Override
    public Account reportAccountStatement(AccountStatementRequest accountStatementRequest) throws ParseException {

        Account account = accountOutputPort.getAccountById(accountStatementRequest.getId())
                .orElseThrow(() -> new AccountNotFound("Account not found with id " + accountStatementRequest.getId()));

        Date startDate = DATE_FORMAT.parse(accountStatementRequest.getStartDate());
        Date endDate = DATE_FORMAT.parse(accountStatementRequest.getEndDate());

        account.setMovements(movementOutputPort
                .reportStatementByAccountId(accountStatementRequest.getId(), startDate, endDate));
        return account;
    }

}

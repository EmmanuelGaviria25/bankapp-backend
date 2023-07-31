package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.model.Account;

import java.util.Optional;

public interface AccountOutputPort {

    Account saveAccount(Account account);

    Account updateAccount(Account account);

    Optional<Account> getAccountById(Long id);

    Optional<Account> getAccountActiveById(Long id);

    void deleteAccountById(Long id);
}

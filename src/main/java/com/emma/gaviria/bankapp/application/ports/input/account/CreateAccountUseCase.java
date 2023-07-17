package com.emma.gaviria.bankapp.application.ports.input.account;

import com.emma.gaviria.bankapp.domain.model.Account;

public interface CreateAccountUseCase {

    Account createAccount(Account account);

}

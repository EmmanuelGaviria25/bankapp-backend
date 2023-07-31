package com.emma.gaviria.bankapp.application.ports.input.account;

import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account.AccountStatementRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountStatementResponse;

import java.text.ParseException;

public interface ReportAccountStatementUseCase {

    Account reportAccountStatement(AccountStatementRequest accountStatementRequest) throws ParseException;

}

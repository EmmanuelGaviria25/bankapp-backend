package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper;

import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account.AccountCreateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account.AccountUpdateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountStatementResponse;
import org.mapstruct.Mapper;

@Mapper
public interface AccountRestMapper {

    Account toAccountCreate(AccountCreateRequest accountCreateRequest);

    Account toAccountUpdate(AccountUpdateRequest accountUpdateRequest);

    AccountResponse toAccountCreateResponse(Account account);

    AccountQueryResponse toAccountQueryResponse(Account account);

    AccountStatementResponse toAccountStatementResponse(Account account);

}

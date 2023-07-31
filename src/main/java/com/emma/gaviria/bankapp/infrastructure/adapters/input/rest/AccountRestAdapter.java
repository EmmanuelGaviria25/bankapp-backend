package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest;

import com.emma.gaviria.bankapp.application.ports.input.account.*;
import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account.AccountCreateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account.AccountStatementRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account.AccountUpdateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountStatementResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper.AccountRestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Log4j2
public class AccountRestAdapter {

    private final CreateAccountUseCase createAccountUseCase;

    private final UpdateAccountUseCase updateAccountUseCase;

    private final GetAccountUseCase getAccountUseCase;

    private final DeleteAccountUseCase deleteAccountUseCase;

    private final ReportAccountStatementUseCase reportAccountStatementUseCase;

    private final AccountRestMapper accountRestMapper;

    @PostMapping(value = "/accounts")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody @Valid AccountCreateRequest accountCreateRequest) {
        Account account = accountRestMapper.toAccountCreate(accountCreateRequest);
        account = createAccountUseCase.createAccount(account);
        return new ResponseEntity<>(accountRestMapper.toAccountCreateResponse(account), HttpStatus.CREATED);
    }

    @GetMapping(value = "/accounts/{id}")
    public ResponseEntity<AccountQueryResponse> getAccount(@PathVariable Long id) {
        Account account = getAccountUseCase.getAccountById(id);
        AccountQueryResponse accountQueryResponse = accountRestMapper.toAccountQueryResponse(account);
        return new ResponseEntity<>(accountQueryResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/accounts")
    public ResponseEntity<AccountResponse> updateAccount(@RequestBody @Valid AccountUpdateRequest accountUpdateRequest) {
        Account account = accountRestMapper.toAccountUpdate(accountUpdateRequest);
        account = updateAccountUseCase.updateAccount(account);
        return new ResponseEntity<>(accountRestMapper.toAccountCreateResponse(account), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        deleteAccountUseCase.deleteAccountById(id);
        return new ResponseEntity<>("Account deleted", HttpStatus.OK);
    }

    @PostMapping(value = "/accounts/statement/report")
    public ResponseEntity<AccountStatementResponse> reportAccountStatement(@RequestBody @Valid AccountStatementRequest accountStatementRequest) throws ParseException {
        Account account = reportAccountStatementUseCase.reportAccountStatement(accountStatementRequest);
        return new ResponseEntity<>(accountRestMapper.toAccountStatementResponse(account), HttpStatus.OK);
    }
}

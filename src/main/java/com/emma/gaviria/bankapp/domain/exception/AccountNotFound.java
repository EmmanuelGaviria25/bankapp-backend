package com.emma.gaviria.bankapp.domain.exception;

public class AccountNotFound extends RuntimeException {

    public AccountNotFound(String message) {
        super(message);
    }

}

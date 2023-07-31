package com.emma.gaviria.bankapp.domain.exception;

public class BalanceNotAvailable extends RuntimeException {

    public BalanceNotAvailable(String message) {
        super(message);
    }

}

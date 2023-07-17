package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.event.account.AccountCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.account.AccountUpdatedEvent;

public interface AccountEventPublisher {

    void publishAccountCreatedEvent(AccountCreatedEvent event);

    void publishAccountUpdatedEvent(AccountUpdatedEvent event);

}

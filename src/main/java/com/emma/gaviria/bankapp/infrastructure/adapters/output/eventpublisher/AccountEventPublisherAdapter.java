package com.emma.gaviria.bankapp.infrastructure.adapters.output.eventpublisher;

import com.emma.gaviria.bankapp.application.ports.output.AccountEventPublisher;
import com.emma.gaviria.bankapp.domain.event.account.AccountCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.account.AccountUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class AccountEventPublisherAdapter implements AccountEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishAccountCreatedEvent(AccountCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishAccountUpdatedEvent(AccountUpdatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}

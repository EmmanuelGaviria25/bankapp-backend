package com.emma.gaviria.bankapp.infrastructure.adapters.output.eventpublisher;

import com.emma.gaviria.bankapp.application.ports.output.PersonEventPublisher;
import com.emma.gaviria.bankapp.domain.event.person.PersonCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.person.PersonUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class PersonEventPublisherAdapter implements PersonEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishPersonCreatedEvent(PersonCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishPersonUpdatedEvent(PersonUpdatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}

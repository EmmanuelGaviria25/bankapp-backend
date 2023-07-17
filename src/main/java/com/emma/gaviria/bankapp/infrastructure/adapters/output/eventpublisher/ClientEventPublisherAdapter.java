package com.emma.gaviria.bankapp.infrastructure.adapters.output.eventpublisher;

import com.emma.gaviria.bankapp.application.ports.output.ClientEventPublisher;
import com.emma.gaviria.bankapp.domain.event.client.ClientCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.client.ClientUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class ClientEventPublisherAdapter implements ClientEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishClientCreatedEvent(ClientCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishClientUpdatedEvent(ClientUpdatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}

package com.emma.gaviria.bankapp.infrastructure.adapters.output.eventpublisher;

import com.emma.gaviria.bankapp.application.ports.output.MovementEventPublisher;
import com.emma.gaviria.bankapp.domain.event.movement.MovementCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.movement.MovementUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class MovementEventPublisherAdapter implements MovementEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishMovementCreatedEvent(MovementCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishMovementUpdatedEvent(MovementUpdatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}

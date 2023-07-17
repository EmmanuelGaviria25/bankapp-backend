package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.event.movement.MovementCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.movement.MovementUpdatedEvent;

public interface MovementEventPublisher {

    void publishMovementCreatedEvent(MovementCreatedEvent event);

    void publishMovementUpdatedEvent(MovementUpdatedEvent event);

}

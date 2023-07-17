package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.event.client.ClientCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.client.ClientUpdatedEvent;

public interface ClientEventPublisher {

    void publishClientCreatedEvent(ClientCreatedEvent event);

    void publishClientUpdatedEvent(ClientUpdatedEvent event);

}

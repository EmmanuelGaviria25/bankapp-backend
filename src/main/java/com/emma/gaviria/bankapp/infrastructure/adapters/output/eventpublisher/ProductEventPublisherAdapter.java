package com.emma.gaviria.bankapp.infrastructure.adapters.output.eventpublisher;

import com.emma.gaviria.bankapp.application.ports.output.ProductEventPublisher;
import com.emma.gaviria.bankapp.domain.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements ProductEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishProductCreatedEvent(ProductCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}

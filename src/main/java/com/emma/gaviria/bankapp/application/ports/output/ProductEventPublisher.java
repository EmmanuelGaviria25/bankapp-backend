package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.event.ProductCreatedEvent;

public interface ProductEventPublisher {

    void publishProductCreatedEvent(ProductCreatedEvent event);

}

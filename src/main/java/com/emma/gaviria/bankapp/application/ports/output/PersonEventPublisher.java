package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.event.person.PersonCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.person.PersonUpdatedEvent;

public interface PersonEventPublisher {

    void publishPersonCreatedEvent(PersonCreatedEvent event);

    void publishPersonUpdatedEvent(PersonUpdatedEvent event);

}

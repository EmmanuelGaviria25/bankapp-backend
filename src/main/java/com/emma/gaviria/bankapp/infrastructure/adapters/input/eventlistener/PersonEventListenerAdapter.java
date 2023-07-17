package com.emma.gaviria.bankapp.infrastructure.adapters.input.eventlistener;

import com.emma.gaviria.bankapp.domain.event.person.PersonCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PersonEventListenerAdapter {

    @EventListener
    public void handle(PersonCreatedEvent event){
        log.info("Person created with id " + event.getId() + " at " + event.getDate());
    }

}

package com.emma.gaviria.bankapp.domain.event.person;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonCreatedEvent {

    private Long id;

    private LocalDateTime date;

    public PersonCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}


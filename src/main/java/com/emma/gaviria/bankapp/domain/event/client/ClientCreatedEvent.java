package com.emma.gaviria.bankapp.domain.event.client;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientCreatedEvent {

    private Long id;

    private LocalDateTime date;

    public ClientCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}


package com.emma.gaviria.bankapp.domain.event.movement;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovementCreatedEvent {

    private Long id;

    private LocalDateTime date;

    public MovementCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}


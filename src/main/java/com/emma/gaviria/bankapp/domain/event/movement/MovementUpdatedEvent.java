package com.emma.gaviria.bankapp.domain.event.movement;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovementUpdatedEvent {

    private Long id;

    private LocalDateTime date;

    public MovementUpdatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}


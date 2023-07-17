package com.emma.gaviria.bankapp.domain.event.account;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdatedEvent {

    private Long id;

    private LocalDateTime date;

    public AccountUpdatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}


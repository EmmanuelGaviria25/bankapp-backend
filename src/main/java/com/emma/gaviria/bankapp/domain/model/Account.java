package com.emma.gaviria.bankapp.domain.model;

import lombok.*;

import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;

    private Long clientId;

    private Client client;

    private String number;

    private String type;

    private String initialBalance;

    private Boolean status;

    private List<Movement> movements;

}

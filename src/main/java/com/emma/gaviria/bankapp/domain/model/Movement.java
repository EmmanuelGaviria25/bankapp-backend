package com.emma.gaviria.bankapp.domain.model;

import lombok.*;

import java.sql.Date;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movement {

    private Long id;

    private Long accountId;

    private Account account;

    private Date date;

    private String type;

    private String value;

    private String balance;
}

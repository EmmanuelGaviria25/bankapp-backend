package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.movement;

import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client.ClientResponse;
import lombok.*;

import java.sql.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementResponse {

    private Long id;

    private AccountResponse account;

    private Date date;

    private String type;

    private String value;

    private String balance;

}

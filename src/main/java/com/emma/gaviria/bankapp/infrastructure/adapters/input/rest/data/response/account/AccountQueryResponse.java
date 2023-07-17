package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account;

import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client.ClientQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.person.PersonQueryResponse;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountQueryResponse {

    private Long id;

    private ClientQueryResponse client;

    private String number;

    private String type;

    private Boolean status;

    private String initialBalance;

}

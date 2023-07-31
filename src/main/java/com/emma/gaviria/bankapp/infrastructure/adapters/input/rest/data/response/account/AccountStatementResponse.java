package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account;

import com.emma.gaviria.bankapp.domain.model.Client;
import com.emma.gaviria.bankapp.domain.model.Movement;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client.ClientResponse;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountStatementResponse {

    private Long id;

    private String number;

    private String type;

    private String initialBalance;

    private Boolean status;

    private List<Movement> movements;
}

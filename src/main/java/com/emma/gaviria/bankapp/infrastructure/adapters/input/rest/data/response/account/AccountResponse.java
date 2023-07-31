package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account;

import com.emma.gaviria.bankapp.domain.model.Movement;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client.ClientResponse;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private Long id;

    private ClientResponse client;

    private String number;

    private String type;

    private Boolean status;

    private String initialBalance;

    private List<Movement> movements;
}

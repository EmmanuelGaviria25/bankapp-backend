package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account;

import com.emma.gaviria.bankapp.domain.model.Client;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateRequest {

    @NotEmpty(message = "Person Id may not be empty")
    private Long clientId;

    @Size(max = 999999999, message = "Number may not be empty")
    private Long number;

    @NotEmpty(message = "Type may not be empty")
    private String type;

    @NotNull(message = "Status may not be empty")
    private Boolean status;

    @Size(message = "Initial balance may not be empty")
    private String initialBalance;
}

package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.account;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdateRequest {

    @NotEmpty(message = "Id may not be empty")
    private String id;

    @NotEmpty(message = "Person Id may not be empty")
    private String clientId;

    @Size(max = 999999999, message = "Number may not be empty")
    private String number;

    @NotEmpty(message = "Type may not be empty")
    private String type;

    @NotNull(message = "Status may not be empty")
    private Boolean status;

    @Size(message = "Initial balance may not be empty")
    private String initialBalance;

}

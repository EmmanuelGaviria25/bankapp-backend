package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.client;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreateRequest {

    @NotEmpty(message = "Person Id may not be empty")
    private Long personId;

    @NotEmpty(message = "Password may not be empty")
    private String password;

    @NotNull(message = "Status may not be empty")
    private Boolean status;

}

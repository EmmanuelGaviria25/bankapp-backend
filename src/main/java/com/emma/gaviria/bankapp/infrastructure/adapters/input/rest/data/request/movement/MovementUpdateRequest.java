package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.movement;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementUpdateRequest {

    @NotEmpty(message = "Id may not be empty")
    private String id;

    @NotEmpty(message = "Account Id may not be empty")
    private String accountId;

    @NotEmpty(message = "Type may not be empty")
    private String type;

    @NotEmpty(message = "Value may not be empty")
    private String value;

    @NotEmpty(message = "Balance may not be empty")
    private String balance;

}

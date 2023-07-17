package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.movement;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementCreateRequest {

    @NotEmpty(message = "Account Id may not be empty")
    private String accountId;

    @NotEmpty(message = "Type may not be empty")
    private String type;

    @NotEmpty(message = "Value may not be empty")
    private String value;

    @NotEmpty(message = "Balance may not be empty")
    private String balance;

}

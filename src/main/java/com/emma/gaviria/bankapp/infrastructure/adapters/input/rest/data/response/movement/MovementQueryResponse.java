package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.movement;

import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountQueryResponse;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementQueryResponse {

    private Long id;

    private AccountQueryResponse account;

    private Date date;

    private String type;

    private String value;

    private String balance;

}

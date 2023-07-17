package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client;

import com.emma.gaviria.bankapp.domain.model.Client;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.person.PersonQueryResponse;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientQueryResponse {

    private Long id;

    private PersonQueryResponse person;

    private String password;

    private Boolean status;

}

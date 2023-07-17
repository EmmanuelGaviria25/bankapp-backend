package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.client;

import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.person.PersonResponse;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    private Long id;

    private PersonResponse person;

    private String password;

    private Boolean status;

}

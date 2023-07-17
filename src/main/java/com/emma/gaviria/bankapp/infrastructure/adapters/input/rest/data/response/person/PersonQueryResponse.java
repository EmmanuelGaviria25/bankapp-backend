package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.person;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonQueryResponse {

    private Long id;

    private String name;

    private String identification;

    private String gender;

    private String age;

    private String address;

    private String phone;

}

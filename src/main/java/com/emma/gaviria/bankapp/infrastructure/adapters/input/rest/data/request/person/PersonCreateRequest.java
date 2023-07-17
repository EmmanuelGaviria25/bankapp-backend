package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.person;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonCreateRequest {

    @NotEmpty(message = "Name may not be empty")
    private String name;

    @NotEmpty(message = "Identification may not be empty")
    private String identification;

    @NotEmpty(message = "Gender may not be empty")
    private String gender;

    @NotEmpty(message = "Age may not be empty")
    private String age;

    @NotEmpty(message = "Address may not be empty")
    private String address;

    @NotEmpty(message = "Phone may not be empty")
    private String phone;

}

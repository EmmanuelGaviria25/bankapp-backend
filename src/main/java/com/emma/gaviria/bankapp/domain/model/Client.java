package com.emma.gaviria.bankapp.domain.model;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    private Long id;

    private Long personId;

    private Person person;

    private String password;

    private Boolean status;
}

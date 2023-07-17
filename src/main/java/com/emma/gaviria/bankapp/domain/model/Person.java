package com.emma.gaviria.bankapp.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private Long id;

    private String name;

    private String identification;

    private String gender;

    private String age;

    private String address;

    private String phone;
}

package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.product;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateResponse {

    private Long id;

    private String name;

    private String description;

}

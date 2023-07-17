package com.emma.gaviria.bankapp.application.ports.input.product;

import com.emma.gaviria.bankapp.domain.model.Product;

public interface GetProductUseCase {

    Product getProductById(Long id);

}

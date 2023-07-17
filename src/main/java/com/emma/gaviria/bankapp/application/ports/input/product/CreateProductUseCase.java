package com.emma.gaviria.bankapp.application.ports.input.product;

import com.emma.gaviria.bankapp.domain.model.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);

}

package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.model.Product;

import java.util.Optional;

public interface ProductOutputPort {

    Product saveProduct(Product product);

    Optional<Product> getProductById(Long id);

}

package com.emma.gaviria.bankapp.domain.service;

import com.emma.gaviria.bankapp.application.ports.output.ProductEventPublisher;
import com.emma.gaviria.bankapp.application.ports.output.ProductOutputPort;
import com.emma.gaviria.bankapp.domain.event.ProductCreatedEvent;
import com.emma.gaviria.bankapp.domain.exception.ProductNotFound;
import com.emma.gaviria.bankapp.domain.model.Product;
import com.emma.gaviria.bankapp.application.ports.input.product.GetProductUseCase;
import com.emma.gaviria.bankapp.application.ports.input.product.CreateProductUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase {

    private final ProductOutputPort productOutputPort;

    private final ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(Product product) {
        product = productOutputPort.saveProduct(product);
        productEventPublisher.publishProductCreatedEvent(new ProductCreatedEvent(product.getId()));
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        return productOutputPort.getProductById(id).orElseThrow(() -> new ProductNotFound("Product not found with id " + id));
    }

}

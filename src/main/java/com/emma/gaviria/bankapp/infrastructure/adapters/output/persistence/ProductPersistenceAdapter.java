package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence;

import com.emma.gaviria.bankapp.application.ports.output.ProductOutputPort;
import com.emma.gaviria.bankapp.domain.model.Product;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.ProductEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);
        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toProduct(productEntity);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Product product = productPersistenceMapper.toProduct(productEntity.get());
        return Optional.of(product);
    }

}

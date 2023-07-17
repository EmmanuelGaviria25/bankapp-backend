package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper;

import com.emma.gaviria.bankapp.domain.model.Product;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);

}

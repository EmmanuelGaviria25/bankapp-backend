package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper;

import com.emma.gaviria.bankapp.domain.model.Product;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.ProductCreateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.product.ProductCreateResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.product.ProductQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRestMapper {

    Product toProduct(ProductCreateRequest productCreateRequest);

    ProductCreateResponse toProductCreateResponse(Product product);

    ProductQueryResponse toProductQueryResponse(Product product);

}

package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest;

import com.emma.gaviria.bankapp.domain.model.Product;
import com.emma.gaviria.bankapp.application.ports.input.product.GetProductUseCase;
import com.emma.gaviria.bankapp.application.ports.input.product.CreateProductUseCase;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.ProductCreateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.product.ProductCreateResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.product.ProductQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductRestAdapter {

    private final CreateProductUseCase createProductUseCase;

    private final GetProductUseCase getProductUseCase;

    private final ProductRestMapper productRestMapper;

    @PostMapping(value = "/products")
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequest){
        Product product = productRestMapper.toProduct(productCreateRequest);

        product = createProductUseCase.createProduct(product);

        return new ResponseEntity<>(productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<ProductQueryResponse> getProduct(@PathVariable Long id){
        Product product = getProductUseCase.getProductById(id);
        return new ResponseEntity<>(productRestMapper.toProductQueryResponse(product), HttpStatus.OK);
    }

}

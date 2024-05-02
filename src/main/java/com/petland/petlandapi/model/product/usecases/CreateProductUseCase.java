package com.petland.petlandapi.model.product.usecases;

import com.petland.petlandapi.model.product.dto.ProductRequestDTO;
import com.petland.petlandapi.model.product.entity.ProductEntity;
import com.petland.petlandapi.model.product.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateProductUseCase {

    private final ProductRepository productRepository;
    public CreateProductUseCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public UUID execute(ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productRequestDTO, productEntity);
        return productRepository.save(productEntity).getId();
    }
}

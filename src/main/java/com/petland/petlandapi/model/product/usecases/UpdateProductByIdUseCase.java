package com.petland.petlandapi.model.product.usecases;

import com.petland.petlandapi.model.product.dto.ProductRequestDTO;
import com.petland.petlandapi.model.product.dto.ProductResponseDTO;
import com.petland.petlandapi.model.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateProductByIdUseCase {
    private final ProductRepository productRepository;
    public UpdateProductByIdUseCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public UUID execute( UUID uuid, ProductRequestDTO productRequestDTO){
        var entity = productRepository.findById(uuid).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
        if (entity != null) {
            if (productRequestDTO.name() != null) {
                entity.setName(productRequestDTO.name());
            }
            entity.setValue(productRequestDTO.value());
            entity.setService(productRequestDTO.service());
            productRepository.save(entity);
            return entity.getId();
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}
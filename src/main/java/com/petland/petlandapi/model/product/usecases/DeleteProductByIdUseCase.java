package com.petland.petlandapi.model.product.usecases;

import com.petland.petlandapi.model.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProductByIdUseCase {

    private final ProductRepository productRepository;
    public DeleteProductByIdUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void execute(UUID id) {
        var entity = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
        if (entity != null) {
            productRepository.deleteById(id);
        }
    }
}

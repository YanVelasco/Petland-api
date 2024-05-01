package com.petland.petlandapi.model.product.controller;

import com.petland.petlandapi.model.product.entity.ProductEntity;
import com.petland.petlandapi.model.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity productEntity) {
        return productRepository.save (productEntity);
    }

    @PutMapping("/{uuid}")
    public ProductEntity updateProduct(@RequestBody ProductEntity productEntity, @PathVariable UUID uuid) {
        return productRepository.save (productEntity);
    }

    @DeleteMapping("/{uuid}")
    public void deleteProduct(@PathVariable UUID uuid) {
        productRepository.deleteById(uuid);
    }

}

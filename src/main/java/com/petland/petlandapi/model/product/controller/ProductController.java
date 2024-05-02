package com.petland.petlandapi.model.product.controller;

import com.petland.petlandapi.model.product.dto.ProductRequestDTO;
import com.petland.petlandapi.model.product.dto.ProductResponseDTO;
import com.petland.petlandapi.model.product.usecases.CreateProductUseCase;
import com.petland.petlandapi.model.product.usecases.DeleteProductByIdUseCase;
import com.petland.petlandapi.model.product.usecases.ListAllProductsUseCase;
import com.petland.petlandapi.model.product.usecases.UpdateProductByIdUseCase;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductByIdUseCase updateProductByIdUseCase;
    private final DeleteProductByIdUseCase deleteProductByIdUseCase;
    private final ListAllProductsUseCase listAllProductsUseCase;

    public ProductController(DeleteProductByIdUseCase deleteProductByIdUseCase, CreateProductUseCase createProductUseCase, UpdateProductByIdUseCase
            updateProductByIdUseCase, ListAllProductsUseCase listAllProductsUseCase) {
        this.deleteProductByIdUseCase = deleteProductByIdUseCase;
        this.createProductUseCase = createProductUseCase;
        this.updateProductByIdUseCase = updateProductByIdUseCase;
        this.listAllProductsUseCase = listAllProductsUseCase;
    }

    @Operation(summary = "Create a new product")
    @PostMapping
    public ResponseEntity<UUID> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        UUID id = createProductUseCase.execute(productRequestDTO);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "Update an existing product")
    @PutMapping("/{uuid}")
    public ResponseEntity<UUID> updateProduct(@PathVariable UUID uuid, @RequestBody ProductRequestDTO productRequestDTO) {
        UUID id = updateProductByIdUseCase.execute(uuid, productRequestDTO);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "Delete a product")
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID uuid) {
        deleteProductByIdUseCase.execute(uuid);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "List all products")
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> listAllProducts() {
        List<ProductResponseDTO> products = listAllProductsUseCase.execute();
        return ResponseEntity.ok(products);
    }
}
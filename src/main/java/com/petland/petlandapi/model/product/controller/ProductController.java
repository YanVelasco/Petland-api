package com.petland.petlandapi.model.product.controller;

import com.petland.petlandapi.model.product.dto.ProductRequestDTO;

import com.petland.petlandapi.model.product.dto.ProductResponseDTO;
import com.petland.petlandapi.model.product.usecases.CreateProductUseCase;
import com.petland.petlandapi.model.product.usecases.DeleteProductByIdUseCase;
import com.petland.petlandapi.model.product.usecases.ListAllProductsUseCase;
import com.petland.petlandapi.model.product.usecases.UpdateProductByIdUseCase;
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

    @PostMapping
    public UUID createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return createProductUseCase.execute(productRequestDTO);
    }

    @PutMapping("/{uuid}")
    public UUID updateProduct( @PathVariable UUID uuid ,@RequestBody ProductRequestDTO productRequestDTO) {
        return updateProductByIdUseCase.execute(uuid, productRequestDTO);
    }

    @DeleteMapping("/{uuid}")
    public void deleteProduct(@PathVariable UUID uuid) {
        deleteProductByIdUseCase.execute(uuid);
    }

    @GetMapping
    public List<ProductResponseDTO> listAllProducts() {
        return listAllProductsUseCase.execute();
    }
}

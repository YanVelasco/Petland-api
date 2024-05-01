package com.petland.petlandapi.model.product.repository;

import com.petland.petlandapi.model.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID>{
}

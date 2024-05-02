package com.petland.petlandapi.model.product.dto;

public record ProductRequestDTO(
        String name,
        double value,
        boolean service
) {
}

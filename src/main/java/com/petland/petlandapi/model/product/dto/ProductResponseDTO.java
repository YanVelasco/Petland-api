package com.petland.petlandapi.model.product.dto;

import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
        String name,
        double value,
        boolean service
) {
}

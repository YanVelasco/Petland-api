package com.petland.petlandapi.model.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

@Schema(description = "Data Transfer Object (DTO) for Product responses. This class holds the necessary information for retrieving a Product.")
public record ProductResponseDTO(
        @Schema(description = "The ID of the Product.")
        UUID id,

        @Schema(description = "The name of the Product.")
        String name,

        @Schema(description = "The value of the Product.")
        double value,

        @Schema(description = "Indicates if the Product is a service.")
        boolean service
) {
}
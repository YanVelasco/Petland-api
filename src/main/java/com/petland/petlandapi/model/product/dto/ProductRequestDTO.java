package com.petland.petlandapi.model.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Data Transfer Object (DTO) for Product requests. This class holds the necessary information for creating or updating a Product.")
public record ProductRequestDTO(
        @Schema(description = "The name of the Product.")
        String name,

        @Schema(description = "The value of the Product.")
        double value,

        @Schema(description = "Indicates if the Product is a service.")
        boolean service
) {
}
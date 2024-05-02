package com.petland.petlandapi.model.animal.dto;

import com.petland.petlandapi.model.animal.entity.Specie;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Data Transfer Object (DTO) for Animal requests. This class holds the necessary information for creating or updating an Animal.")
public record AnimalRequestDTO(
        @Schema(description = "The name of the Animal.")
        String name,

        @Schema(description = "The date of birth of the Animal.")
        LocalDateTime bornDate,

        @Schema(description = "The specie of the Animal.")
        Specie specie,

        @Schema(description = "The registration ID associated with the Animal.")
        UUID registrationId
) {
}
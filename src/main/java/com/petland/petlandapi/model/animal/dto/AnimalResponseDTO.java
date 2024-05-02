package com.petland.petlandapi.model.animal.dto;

import com.petland.petlandapi.model.animal.entity.Specie;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Data Transfer Object (DTO) for Animal responses. This class holds the necessary information for retrieving an Animal.")
public record AnimalResponseDTO(
        @Schema(description = "The ID of the Animal.")
        UUID id,

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
package com.petland.petlandapi.model.register.dto;

import com.petland.petlandapi.model.register.Address;
import com.petland.petlandapi.model.register.entity.Profile;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Data Transfer Object (DTO) for Registration responses. This class holds the necessary information for retrieving a Registration.")
public record RegistrationResponseDTO(
        @Schema(description = "The ID of the Registration.")
        UUID id,

        @Schema(description = "The name associated with the Registration.")
        String name,

        @Schema(description = "The profile associated with the Registration.")
        Profile profile,

        @Schema(description = "The address associated with the Registration.")
        Address address
) {
}
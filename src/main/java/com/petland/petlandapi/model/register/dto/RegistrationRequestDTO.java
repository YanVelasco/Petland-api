package com.petland.petlandapi.model.register.dto;

import com.petland.petlandapi.model.register.entity.Address;
import com.petland.petlandapi.model.register.entity.Profile;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Data Transfer Object (DTO) for Registration requests. This class holds the necessary information for creating or updating a Registration.")
public record RegistrationRequestDTO(
        @Schema(description = "The name associated with the Registration.")
        String name,

        @Schema(description = "The profile associated with the Registration.")
        Profile profile,

        @Schema(description = "The address associated with the Registration.")
        Address address
        ) {
}
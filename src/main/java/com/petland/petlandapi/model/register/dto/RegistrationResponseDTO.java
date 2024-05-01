package com.petland.petlandapi.model.register.dto;

import com.petland.petlandapi.model.register.Address;
import com.petland.petlandapi.model.register.entity.Profile;

import java.util.UUID;

public record RegistrationResponseDTO(
        UUID id,
        String name,
        Profile profile,
        Address address
) {
}

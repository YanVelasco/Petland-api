package com.petland.petlandapi.model.animal.dto;

import com.petland.petlandapi.model.animal.entity.Specie;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;

import java.time.LocalDateTime;
import java.util.UUID;


public record AnimalResponseDTO(
        UUID id,
        String name,
        LocalDateTime bornDate,
        Specie specie,
        UUID registrationId
) {
}

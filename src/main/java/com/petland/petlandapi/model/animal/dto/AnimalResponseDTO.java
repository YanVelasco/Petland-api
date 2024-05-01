package com.petland.petlandapi.model.animal.dto;

import com.petland.petlandapi.model.animal.entity.Specie;

import java.time.LocalDateTime;
import java.util.UUID;


public record AnimalResponseDTO(
        UUID id,
        String name,
        LocalDateTime bornDate,
        Specie specie
) {
}

package com.petland.petlandapi.model.animal.dto;

import com.petland.petlandapi.model.animal.entity.Specie;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record AnimalRequestDTO(
        String name,
        LocalDateTime bornDate,
        Specie specie
) {
}
package com.petland.petlandapi.model.register.dto;

import com.petland.petlandapi.model.register.Address;
import com.petland.petlandapi.model.register.entity.Profile;

public record RegistrationRequestDTO(
        String name,
        Profile profile,
        Address address
        ) {
}

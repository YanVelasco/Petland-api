package com.petland.petlandapi.model.customer.dto;

import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import com.petland.petlandapi.model.customer.entity.CustomerServiceStatus;
import com.petland.petlandapi.model.customer.entity.CustomerServiceType;
import com.petland.petlandapi.model.product.entity.ProductEntity;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerServiceResponseDTO(
        UUID id,
        CustomerServiceType type,
        CustomerServiceStatus status,
        String description,
        LocalDate dateRealized,
        LocalDate timeRealized,
        boolean emergency,
        RegistrationEntity registrationEntity,
        ProductEntity serviceEntity,
        AnimalEntity patientEntity,
        double value
) {
}

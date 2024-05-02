package com.petland.petlandapi.model.customerservice.dto;

import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import com.petland.petlandapi.model.customerservice.entity.CustomerServiceStatus;
import com.petland.petlandapi.model.customerservice.entity.CustomerServiceType;
import com.petland.petlandapi.model.product.entity.ProductEntity;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerServiceRequireDTO(
        CustomerServiceType type,
        CustomerServiceStatus status,
        String description,
        LocalDate dateRealized,
        LocalDate timeRealized,
        boolean emergency,
        UUID registrationId,
        UUID productId,
        UUID animalId,
        double value
) {
}
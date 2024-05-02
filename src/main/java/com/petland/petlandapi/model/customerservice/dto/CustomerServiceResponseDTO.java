package com.petland.petlandapi.model.customerservice.dto;

import com.petland.petlandapi.model.customerservice.entity.CustomerServiceStatus;
import com.petland.petlandapi.model.customerservice.entity.CustomerServiceType;

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
        UUID registrationEntity,
        UUID serviceEntity,
        UUID patientEntity,
        double value
) {
}

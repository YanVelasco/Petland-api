package com.petland.petlandapi.model.customerservice.controller.dto;

import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import com.petland.petlandapi.model.customerservice.entity.CustomerServiceStatus;
import com.petland.petlandapi.model.customerservice.entity.CustomerServiceType;
import com.petland.petlandapi.model.product.entity.ProductEntity;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;
import jakarta.persistence.Column;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "Data Transfer Object (DTO) for Customer Service requests. This class holds the necessary information for creating or updating a Customer Service.")
public record CustomerServiceRequireDTO(
        @Schema(description = "The type of the Customer Service.")
        CustomerServiceType type,

        @Schema(description = "The status of the Customer Service.")
        CustomerServiceStatus status,

        @Schema(description = "The description of the Customer Service.")
        String description,

        @Schema(description = "The date when the Customer Service was realized.")
        LocalDate dateRealized,

        @Schema(description = "The time when the Customer Service was realized.")
        LocalDate timeRealized,

        @Schema(description = "Indicates if the Customer Service is an emergency.")
        boolean emergency,

        @Schema(description = "The registration ID associated with the Customer Service.")
        UUID registrationId,

        @Schema(description = "The product ID associated with the Customer Service.")
        UUID productId,

        @Schema(description = "The animal ID associated with the Customer Service.")
        UUID animalId,

        @Schema(description = "The value of the Customer Service.")
        double value
) {
}
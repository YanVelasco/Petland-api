package com.petland.petlandapi.model.customerservice.controller.dto;

import com.petland.petlandapi.model.customerservice.entity.CustomerServiceStatus;
import com.petland.petlandapi.model.customerservice.entity.CustomerServiceType;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "Data Transfer Object (DTO) for Customer Service responses. This class holds the necessary information for retrieving a Customer Service.")
public record CustomerServiceResponseDTO(
        @Schema(description = "The ID of the Customer Service.")
        UUID id,

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

        @Schema(description = "The registration entity associated with the Customer Service.")
        UUID registrationEntity,

        @Schema(description = "The service entity associated with the Customer Service.")
        UUID serviceEntity,

        @Schema(description = "The patient entity associated with the Customer Service.")
        UUID patientEntity,

        @Schema(description = "The value of the Customer Service.")
        double value
) {
}
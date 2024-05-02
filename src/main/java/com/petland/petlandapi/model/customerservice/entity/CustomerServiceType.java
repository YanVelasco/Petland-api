package com.petland.petlandapi.model.customerservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enumeration for Customer Service Type. This enum holds the possible types for a Customer Service.")
public enum CustomerServiceType {

    @Schema(description = "The Customer Service is a consult.")
    CONSULT,

    @Schema(description = "The Customer Service is a vaccine.")
    VACCINE,

    @Schema(description = "The Customer Service is a checkup.")
    CHECKUP,

    @Schema(description = "The Customer Service is a sanization.")
    SANIZATION
}
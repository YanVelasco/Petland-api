package com.petland.petlandapi.model.customerservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enumeration for Customer Service Status. This enum holds the possible statuses for a Customer Service.")
public enum CustomerServiceStatus {

    @Schema(description = "The Customer Service is being scheduled.")
    SCHEDULLING,

    @Schema(description = "The Customer Service is currently running.")
    ISRUNNING,

    @Schema(description = "The Customer Service has finished.")
    FINISHED,

    @Schema(description = "The Customer Service has been canceled.")
    CANCELED
}
package com.petland.petlandapi.model.register.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Embeddable entity for Profile. This class holds the necessary information for storing a Profile in the database.")
public class Profile {

    @Schema(description = "Indicates if the profile is a client.")
    private boolean client;

    @Schema(description = "Indicates if the profile is a supplier.")
    private boolean supplier;

    @Schema(description = "Indicates if the profile is a provider.")
    private boolean provider;
}
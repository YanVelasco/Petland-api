package com.petland.petlandapi.model.register.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "registrations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity for Registration. This class holds the necessary information for storing a Registration in the database.")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    @Schema(description = "The ID of the Registration.")
    private UUID id;

    @Schema(description = "The name associated with the Registration.")
    private String name;

    @Embedded
    @Schema(description = "The profile associated with the Registration.")
    private Profile profile;

    @Embedded
    @Schema(description = "The address associated with the Registration.")
    private Address address;

}
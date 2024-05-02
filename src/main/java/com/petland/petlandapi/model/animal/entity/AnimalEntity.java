package com.petland.petlandapi.model.animal.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity for Animal. This class holds the necessary information for storing an Animal in the database.")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    @Schema(description = "The ID of the Animal.")
    private UUID id;

    @Schema(description = "The name of the Animal.")
    private String name;

    @Schema(description = "The born date of the Animal.")
    private LocalDateTime bornDate;

    @Enumerated(EnumType.STRING)
    @Schema(description = "The specie of the Animal.")
    private Specie specie;

    @Column(name = "registration_id")
    @Schema(description = "The registration ID associated with the Animal.")
    private UUID registrationId;
}
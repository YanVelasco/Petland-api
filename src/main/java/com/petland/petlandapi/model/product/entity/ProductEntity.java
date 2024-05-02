package com.petland.petlandapi.model.product.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity for Product. This class holds the necessary information for storing a Product in the database.")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    @Schema(description = "The ID of the Product.")
    private UUID id;

    @Schema(description = "The name of the Product.")
    private String name;

    @Schema(description = "The value of the Product.")
    private double value;

    @Schema(description = "Indicates if the Product is a service.")
    private boolean service;

}
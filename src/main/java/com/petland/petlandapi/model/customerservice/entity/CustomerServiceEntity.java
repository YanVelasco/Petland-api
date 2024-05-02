package com.petland.petlandapi.model.customerservice.entity;

import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import com.petland.petlandapi.model.product.entity.ProductEntity;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "customer_services")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity for Customer Service. This class holds the necessary information for storing a Customer Service in the database.")
public class CustomerServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    @Schema(description = "The ID of the Customer Service.")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Schema(description = "The type of the Customer Service.")
    private CustomerServiceType type;

    @Enumerated(EnumType.STRING)
    @Schema(description = "The status of the Customer Service.")
    private CustomerServiceStatus status;

    @Schema(description = "The description of the Customer Service.")
    private String description;

    @Schema(description = "The date the Customer Service was realized.")
    private LocalDate dateRealized;

    @Schema(description = "The time the Customer Service was realized.")
    private LocalDate timeRealized;

    @Schema(description = "Indicates if the Customer Service is an emergency.")
    private boolean emergency;

    @Column(name = "registration_id")
    @Schema(description = "The registration ID associated with the Customer Service.")
    private UUID registrationId;

    @Column(name = "product_id")
    @Schema(description = "The product ID associated with the Customer Service.")
    private UUID productId;

    @Column(name = "animal_id")
    @Schema(description = "The animal ID associated with the Customer Service.")
    private UUID animalId;

    @Schema(description = "The value of the Customer Service.")
    private double value;

}
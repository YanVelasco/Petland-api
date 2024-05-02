package com.petland.petlandapi.model.customerservice.entity;


import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import com.petland.petlandapi.model.product.entity.ProductEntity;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "customer_services")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private CustomerServiceType type;

    @Enumerated(EnumType.STRING)
    private CustomerServiceStatus status;

    private String description;

    private LocalDate dateRealized;

    private LocalDate timeRealized;
    private boolean emergency;

    @ManyToOne
    private RegistrationEntity registrationEntity;

    @ManyToOne
    private ProductEntity serviceEntity;

    @ManyToOne
    private AnimalEntity patientEntity;

    private double value;

}
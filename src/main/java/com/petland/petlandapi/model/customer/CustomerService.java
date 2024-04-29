package com.petland.petlandapi.model.customer;


import com.petland.petlandapi.model.animal.Animal;
import com.petland.petlandapi.model.product.Product;
import com.petland.petlandapi.model.register.Registration;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "customer_services")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerService {

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
    private Registration registration;

    @ManyToOne
    private Product service;

    @ManyToOne
    private Animal patient;

    private double value;

}

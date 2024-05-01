package com.petland.petlandapi.model.register.entity;

import com.petland.petlandapi.model.register.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "registrations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;

    @Embedded
    private Profile profile;

    @Embedded
    private Address address;

}

package com.petland.petlandapi.model.register;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "registrations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private Profile profile;

    @Embedded
    private Address address;

}

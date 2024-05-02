package com.petland.petlandapi.model.animal.entity;

import com.petland.petlandapi.model.register.entity.RegistrationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String name;

    private LocalDateTime bornDate;

    @Enumerated(EnumType.STRING)
    private Specie specie;

    @Column(name = "registration_id")
    private UUID registrationId;
}

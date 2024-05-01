package com.petland.petlandapi.model.register.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private boolean client;
    private boolean supplier;
    private boolean provider;
}

package com.petland.petlandapi.model.register.repository;

import com.petland.petlandapi.model.register.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, UUID>{
}

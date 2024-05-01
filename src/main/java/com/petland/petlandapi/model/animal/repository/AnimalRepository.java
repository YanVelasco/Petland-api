package com.petland.petlandapi.model.animal.repository;

import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalRepository extends JpaRepository<AnimalEntity, UUID> {
}

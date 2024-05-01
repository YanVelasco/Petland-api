package com.petland.petlandapi.model.customer.repository;

import com.petland.petlandapi.model.customer.entity.CustomerServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerServiceRepository extends JpaRepository<CustomerServiceEntity, UUID>{
}

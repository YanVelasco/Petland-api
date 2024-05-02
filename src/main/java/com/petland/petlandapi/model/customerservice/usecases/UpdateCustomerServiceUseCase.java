package com.petland.petlandapi.model.customerservice.usecases;

import com.petland.petlandapi.model.customerservice.dto.CustomerServiceRequireDTO;
import com.petland.petlandapi.model.customerservice.repository.CustomerServiceRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCustomerServiceUseCase {
    private final CustomerServiceRepository customerServiceRepository;

    public UpdateCustomerServiceUseCase(CustomerServiceRepository customerServiceRepository) {
        this.customerServiceRepository = customerServiceRepository;
    }

    public UUID execute(UUID id, CustomerServiceRequireDTO customerServiceRequireDTO) {
        var entity = customerServiceRepository.findById (id).orElseThrow (() -> new RuntimeException ("Customer Service not found"));

        if (customerServiceRequireDTO.type () != null) {
            entity.setType (customerServiceRequireDTO.type ());
        }
        if (customerServiceRequireDTO.status () != null) {
            entity.setStatus (customerServiceRequireDTO.status ());
        }
        if (customerServiceRequireDTO.description () != null) {
            entity.setDescription (customerServiceRequireDTO.description ());
        }
        if (customerServiceRequireDTO.dateRealized () != null) {
            entity.setDateRealized (customerServiceRequireDTO.dateRealized ());
        }
        if (customerServiceRequireDTO.timeRealized () != null) {
            entity.setTimeRealized (customerServiceRequireDTO.timeRealized ());
        }

        if (customerServiceRequireDTO.emergency ()) {
            entity.setEmergency(false);
        }

        if (customerServiceRequireDTO.value () != 0.0) {
            entity.setValue (customerServiceRequireDTO.value ());
        }

        var savedEntity = customerServiceRepository.save (entity);
        return savedEntity.getId ();
    }
}
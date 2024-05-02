package com.petland.petlandapi.model.customerservice.usecases;

import com.petland.petlandapi.model.customerservice.repository.CustomerServiceRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCustomerServiceByIdUseCase {
    private final CustomerServiceRepository customerServiceRepository;

    public DeleteCustomerServiceByIdUseCase(CustomerServiceRepository customerServiceRepository) {
        this.customerServiceRepository = customerServiceRepository;
    }

    public void execute(UUID id) {
        var entity = customerServiceRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer Service not found")
        );
        customerServiceRepository.deleteById(entity.getId());
    }
}

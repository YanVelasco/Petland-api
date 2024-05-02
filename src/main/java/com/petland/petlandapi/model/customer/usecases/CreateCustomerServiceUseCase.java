package com.petland.petlandapi.model.customer.usecases;

import com.petland.petlandapi.model.animal.repository.AnimalRepository;
import com.petland.petlandapi.model.customer.dto.CustomerServiceRequireDTO;
import com.petland.petlandapi.model.customer.entity.CustomerServiceEntity;
import com.petland.petlandapi.model.customer.repository.CustomerServiceRepository;
import com.petland.petlandapi.model.product.repository.ProductRepository;
import com.petland.petlandapi.model.register.repository.RegistrationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateCustomerServiceUseCase {
    private final CustomerServiceRepository customerServiceRepository;
    private final AnimalRepository animalRepository;
    private final ProductRepository productRepository;
    private final RegistrationRepository registrationRepository;

    public CreateCustomerServiceUseCase(CustomerServiceRepository customerServiceRepository, AnimalRepository animalRepository, ProductRepository productRepository, RegistrationRepository registrationRepository) {
        this.customerServiceRepository = customerServiceRepository;
        this.animalRepository = animalRepository;
        this.productRepository = productRepository;
        this.registrationRepository = registrationRepository;
    }

    public UUID execute(CustomerServiceRequireDTO customerServiceRequireDTO) {
        registrationRepository.findById (customerServiceRequireDTO.registrationEntity ().getId ())
                .orElseThrow (() -> new RuntimeException ("Registration not found"));

        productRepository.findById (customerServiceRequireDTO.serviceEntity ().getId ())
                .orElseThrow (() -> new RuntimeException ("Product not found"));

        animalRepository.findById (customerServiceRequireDTO.patientEntity ().getId ())
                .orElseThrow (() -> new RuntimeException ("Animal not found"));

        CustomerServiceEntity entity = new CustomerServiceEntity ();
        BeanUtils.copyProperties (customerServiceRequireDTO, entity);

        var savedEntity = customerServiceRepository.save (entity);
        return savedEntity.getId ();
    }
}
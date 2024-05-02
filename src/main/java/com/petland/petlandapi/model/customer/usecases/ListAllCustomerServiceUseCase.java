package com.petland.petlandapi.model.customer.usecases;

import com.petland.petlandapi.model.customer.dto.CustomerServiceResponseDTO;
import com.petland.petlandapi.model.customer.entity.CustomerServiceEntity;
import com.petland.petlandapi.model.customer.repository.CustomerServiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListAllCustomerServiceUseCase {
    private final CustomerServiceRepository customerServiceRepository;
    public ListAllCustomerServiceUseCase(CustomerServiceRepository customerServiceRepository) {
        this.customerServiceRepository = customerServiceRepository;
    }
    public List<CustomerServiceResponseDTO> execute() {
    List<CustomerServiceEntity> customerServiceEntities = customerServiceRepository.findAll();
    List<CustomerServiceResponseDTO> customerServiceResponseDTOS = new ArrayList<>();
    for (CustomerServiceEntity customerServiceEntity : customerServiceEntities) {
        customerServiceResponseDTOS.add(new CustomerServiceResponseDTO(
                customerServiceEntity.getId(),
                customerServiceEntity.getType(),
                customerServiceEntity.getStatus(),
                customerServiceEntity.getDescription(),
                customerServiceEntity.getDateRealized(),
                customerServiceEntity.getTimeRealized(),
                customerServiceEntity.isEmergency(),
                customerServiceEntity.getRegistrationEntity(),
                customerServiceEntity.getServiceEntity(),
                customerServiceEntity.getPatientEntity(),
                customerServiceEntity.getValue()
        ));
    }
    return customerServiceResponseDTOS;
}
}

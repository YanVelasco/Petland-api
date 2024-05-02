package com.petland.petlandapi.model.customer.controller;

import com.petland.petlandapi.model.customer.dto.CustomerServiceRequireDTO;
import com.petland.petlandapi.model.customer.dto.CustomerServiceResponseDTO;
import com.petland.petlandapi.model.customer.usecases.CreateCustomerServiceUseCase;
import com.petland.petlandapi.model.customer.usecases.DeleteCustomerServiceByIdUseCase;
import com.petland.petlandapi.model.customer.usecases.ListAllCustomerServiceUseCase;
import com.petland.petlandapi.model.customer.usecases.UpdateCustomerServiceUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service")
public class ProductServiceController {
    private final CreateCustomerServiceUseCase createCustomerServiceUseCase;
    private  final ListAllCustomerServiceUseCase listAllCustomerServiceUseCase;
    private final UpdateCustomerServiceUseCase updateCustomerServiceUseCase;
    private final DeleteCustomerServiceByIdUseCase deleteCustomerServiceUseCase;

    public ProductServiceController(CreateCustomerServiceUseCase createCustomerServiceUseCase, ListAllCustomerServiceUseCase listAllCustomerServiceUseCase, UpdateCustomerServiceUseCase updateCustomerServiceUseCase, DeleteCustomerServiceByIdUseCase deleteCustomerServiceUseCase) {
        this.createCustomerServiceUseCase = createCustomerServiceUseCase;
        this.listAllCustomerServiceUseCase = listAllCustomerServiceUseCase;
        this.updateCustomerServiceUseCase = updateCustomerServiceUseCase;
        this.deleteCustomerServiceUseCase = deleteCustomerServiceUseCase;
    }

    @PostMapping
    public UUID createCustomerService(@RequestBody CustomerServiceRequireDTO customerServiceRequireDTO) {
        return createCustomerServiceUseCase.execute(customerServiceRequireDTO);
    }

    @GetMapping
    public List<CustomerServiceResponseDTO> listAllCustomerService() {
        return listAllCustomerServiceUseCase.execute();
    }

    @PutMapping("/{id}")
    public void updateCustomerService(@PathVariable UUID id, @RequestBody CustomerServiceRequireDTO customerServiceRequireDTO) {
        updateCustomerServiceUseCase.execute(id, customerServiceRequireDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerService(@PathVariable UUID id) {
        deleteCustomerServiceUseCase.execute(id);
    }
}
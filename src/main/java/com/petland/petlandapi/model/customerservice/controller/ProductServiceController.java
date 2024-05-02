package com.petland.petlandapi.model.customerservice.controller;

import com.petland.petlandapi.model.customerservice.controller.dto.CustomerServiceRequireDTO;
import com.petland.petlandapi.model.customerservice.controller.dto.CustomerServiceResponseDTO;
import com.petland.petlandapi.model.customerservice.usecases.CreateCustomerServiceUseCase;
import com.petland.petlandapi.model.customerservice.usecases.DeleteCustomerServiceByIdUseCase;
import com.petland.petlandapi.model.customerservice.usecases.ListAllCustomerServiceUseCase;
import com.petland.petlandapi.model.customerservice.usecases.UpdateCustomerServiceUseCase;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
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

    @Operation(summary = "Create a new customer service")
    @PostMapping
    public ResponseEntity<UUID> createCustomerService(@RequestBody CustomerServiceRequireDTO customerServiceRequireDTO) {
        UUID id = createCustomerServiceUseCase.execute(customerServiceRequireDTO);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "View a list of all customer services")
    @GetMapping
    public ResponseEntity<List<CustomerServiceResponseDTO>> listAllCustomerService() {
        List<CustomerServiceResponseDTO> services = listAllCustomerServiceUseCase.execute();
        return ResponseEntity.ok(services);
    }

    @Operation(summary = "Update an existing customer service")
    @PutMapping("/{id}")
    public ResponseEntity<UUID> updateCustomerService(@PathVariable UUID id, @RequestBody CustomerServiceRequireDTO customerServiceRequireDTO) {
        updateCustomerServiceUseCase.execute(id, customerServiceRequireDTO);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "Delete a customer service")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerService(@PathVariable UUID id) {
        deleteCustomerServiceUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
package com.petland.petlandapi.model.register.controller;

import com.petland.petlandapi.model.register.dto.RegistrationRequestDTO;
import com.petland.petlandapi.model.register.dto.RegistrationResponseDTO;
import com.petland.petlandapi.model.register.usecases.AlterRegistersByIdUseCase;
import com.petland.petlandapi.model.register.usecases.CreateRegistrationUseCase;
import com.petland.petlandapi.model.register.usecases.DeleteRegistrationIdUseCase;
import com.petland.petlandapi.model.register.usecases.ListAllRegistrationsUseCase;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final ListAllRegistrationsUseCase listAllRegistrationsUseCase;
    private final CreateRegistrationUseCase createRegistrationUseCase;
    private final AlterRegistersByIdUseCase alterRegistersByIdUseCase;
    private final DeleteRegistrationIdUseCase  deleteRegistrationIdUseCase;

    public RegistrationController(ListAllRegistrationsUseCase listAllRegistrationsUseCase, CreateRegistrationUseCase createRegistrationUseCase, AlterRegistersByIdUseCase alterRegistersByIdUseCase, DeleteRegistrationIdUseCase deleteRegistrationIdUseCase) {
        this.listAllRegistrationsUseCase = listAllRegistrationsUseCase;
        this.createRegistrationUseCase = createRegistrationUseCase;
        this.alterRegistersByIdUseCase = alterRegistersByIdUseCase;
        this.deleteRegistrationIdUseCase = deleteRegistrationIdUseCase;
    }

    @Operation(summary = "Create a new registration")
    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody RegistrationRequestDTO registrationRequestDTO) {
        UUID id = createRegistrationUseCase.execute(registrationRequestDTO);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "List all registrations")
    @GetMapping
    public ResponseEntity<List<RegistrationResponseDTO>> listAll() {
        List<RegistrationResponseDTO> registrations = listAllRegistrationsUseCase.execute();
        return ResponseEntity.ok(registrations);
    }

    @Operation(summary = "Update an existing registration")
    @PutMapping("/{id}")
    public ResponseEntity<UUID> update(@PathVariable UUID id, @RequestBody RegistrationRequestDTO registrationRequestDTO) {
        UUID updatedId = alterRegistersByIdUseCase.execute(id, registrationRequestDTO);
        return ResponseEntity.ok(updatedId);
    }

    @Operation(summary = "Delete a registration")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteRegistrationIdUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
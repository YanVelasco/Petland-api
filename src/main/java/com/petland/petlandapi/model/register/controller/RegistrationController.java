package com.petland.petlandapi.model.register.controller;

import com.petland.petlandapi.model.register.dto.RegistrationRequestDTO;
import com.petland.petlandapi.model.register.dto.RegistrationResponseDTO;
import com.petland.petlandapi.model.register.usecases.AlterRegistersByIdUseCase;
import com.petland.petlandapi.model.register.usecases.CreateRegistrationUseCase;
import com.petland.petlandapi.model.register.usecases.DeleteRegistrationIdUseCase;
import com.petland.petlandapi.model.register.usecases.ListAllRegistrationsUseCase;
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

    @PostMapping
    public UUID create(@RequestBody RegistrationRequestDTO registrationRequestDTO) {
        return  createRegistrationUseCase.execute( registrationRequestDTO);
    }

    @GetMapping
    public List<RegistrationResponseDTO> listAll() {
        return listAllRegistrationsUseCase.execute();
    }

    @PutMapping("/{id}")
    public UUID update(@PathVariable("id") UUID id, @RequestBody RegistrationRequestDTO registrationRequestDTO) {
        return alterRegistersByIdUseCase.execute(id, registrationRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        deleteRegistrationIdUseCase.execute(id);
    }

}

package com.petland.petlandapi.model.animal.controller;

import com.petland.petlandapi.model.animal.dto.AnimalRequestDTO;
import com.petland.petlandapi.model.animal.dto.AnimalResponseDTO;
import com.petland.petlandapi.model.animal.usecases.AlterAnimalByIdUseCase;
import com.petland.petlandapi.model.animal.usecases.CreateAnimalUseCase;
import com.petland.petlandapi.model.animal.usecases.DeleteAnimalByIdUseCase;
import com.petland.petlandapi.model.animal.usecases.ListAllAnimalsUseCase;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final ListAllAnimalsUseCase listAllAnimalsUseCase;

    private final CreateAnimalUseCase createAnimalUseCase;

    private final AlterAnimalByIdUseCase alterAnimalByIdUseCase;

    private final DeleteAnimalByIdUseCase deleteAnimalByIdUseCase;

    public AnimalController(ListAllAnimalsUseCase listAllAnimalsUseCase, CreateAnimalUseCase createAnimalUseCase, AlterAnimalByIdUseCase alterAnimalByIdUseCase, DeleteAnimalByIdUseCase deleteAnimalByIdUseCase) {
        this.listAllAnimalsUseCase = listAllAnimalsUseCase;
        this.createAnimalUseCase = createAnimalUseCase;
        this.alterAnimalByIdUseCase = alterAnimalByIdUseCase;
        this.deleteAnimalByIdUseCase = deleteAnimalByIdUseCase;
    }

    @Operation(summary = "Get all animals")
    @GetMapping
    public ResponseEntity<List<AnimalResponseDTO>> getAllAnimals() {
        List<AnimalResponseDTO> animals = listAllAnimalsUseCase.execute();
        return ResponseEntity.ok(animals);
    }

    @Operation(summary = "Create a new animal")
    @PostMapping
    public ResponseEntity<UUID> createAnimal(@RequestBody AnimalRequestDTO animalRequestDTO) {
        UUID id = createAnimalUseCase.execute(animalRequestDTO);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "Update an existing animal")
    @PutMapping("/{id}")
    public ResponseEntity<UUID> updateAnimal(@PathVariable UUID id, @RequestBody AnimalRequestDTO animalRequestDTO) {
        alterAnimalByIdUseCase.execute(id, animalRequestDTO);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "Delete an animal")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable UUID id) {
        deleteAnimalByIdUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
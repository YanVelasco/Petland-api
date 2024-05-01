package com.petland.petlandapi.model.animal.controller;

import com.petland.petlandapi.model.animal.dto.AnimalRequestDTO;
import com.petland.petlandapi.model.animal.dto.AnimalResponseDTO;
import com.petland.petlandapi.model.animal.usecases.AlterAnimalByIdUseCase;
import com.petland.petlandapi.model.animal.usecases.CreateAnimalUseCase;
import com.petland.petlandapi.model.animal.usecases.DeleteAnimalByIdUseCase;
import com.petland.petlandapi.model.animal.usecases.ListAllAnimalsUseCase;
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


    @GetMapping
    public List<AnimalResponseDTO> getAllAnimals() {
        return listAllAnimalsUseCase.execute ();
    }

    @PostMapping
    public UUID createAnimal(@RequestBody AnimalRequestDTO animalRequestDTO) {
        return createAnimalUseCase.execute (animalRequestDTO);
    }

    @PutMapping("/{id}")
    public UUID updateAnimal(@PathVariable("id") UUID id, @RequestBody AnimalRequestDTO animalRequestDTO) {
        alterAnimalByIdUseCase.execute (id, animalRequestDTO);
        return id;
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable("id") UUID id) {
        deleteAnimalByIdUseCase.execute (id);
    }

}

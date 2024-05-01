package com.petland.petlandapi.model.animal.usecases;

import com.petland.petlandapi.model.animal.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteAnimalByIdUseCase {

    private final AnimalRepository animalRepository;

    public DeleteAnimalByIdUseCase(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void execute(UUID id){
        var entity = animalRepository.findById (id).orElseThrow (
                () -> new RuntimeException ("Animal not found")
        );

        if (entity != null) {
            animalRepository.deleteById (id);
        }
    }
}

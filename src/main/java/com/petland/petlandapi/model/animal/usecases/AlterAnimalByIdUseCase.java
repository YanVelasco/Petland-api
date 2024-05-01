package com.petland.petlandapi.model.animal.usecases;

import com.petland.petlandapi.model.animal.dto.AnimalRequestDTO;
import com.petland.petlandapi.model.animal.dto.AnimalResponseDTO;
import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import com.petland.petlandapi.model.animal.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AlterAnimalByIdUseCase {

    private final AnimalRepository animalRepository;

    public AlterAnimalByIdUseCase(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public UUID execute(UUID id, AnimalRequestDTO animalRequestDTO){
        AnimalEntity entity = animalRepository.findById (id).orElseThrow (
                () -> new RuntimeException ("Animal not found")
        );

        if (entity != null) {
            if (animalRequestDTO.name() != null) {
                entity.setName(animalRequestDTO.name());
            }
            if (animalRequestDTO.bornDate() != null) {
                entity.setBornDate(animalRequestDTO.bornDate());
            }
            if (animalRequestDTO.specie () != null) {
                entity.setSpecie(animalRequestDTO.specie ());
            }
            animalRepository.save (entity);
            return entity.getId ();
        } else {
            throw new RuntimeException("Animal not found");
        }
    }
}

package com.petland.petlandapi.model.animal.usecases;

import com.petland.petlandapi.model.animal.dto.AnimalRequestDTO;
import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import com.petland.petlandapi.model.animal.repository.AnimalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateAnimalUseCase {
    private final AnimalRepository animalRepository;
    public CreateAnimalUseCase(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    public UUID execute(AnimalRequestDTO animalRequestDTO) {
        AnimalEntity animalEntity = new AnimalEntity();
        BeanUtils.copyProperties(animalRequestDTO, animalEntity);
        return animalRepository.save(animalEntity).getId ();
    }
}
